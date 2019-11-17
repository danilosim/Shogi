package com.shogi;

import com.shogi.pieces.King;
import com.shogi.pieces.Knight;
import com.shogi.pieces.Lance;
import com.shogi.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player[] players = new Player[2];
    private Board board;
    private Player currentTurn;
    private List<Move> movesPlayed = new ArrayList<>();
    private GameStatus status = GameStatus.ACTIVE;

    /* CREATION & INITIALIZATION OF BOARD */

    public void initialize(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;

        board = new Board();
        board.initialize();

        if (p1.isBlack()){
            setCurrentTurn(p1);
        } else {
            setCurrentTurn(p2);
        }
    }

    /* GENERATES A MOVE */

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY){


        Spot endingSpot = board.getSpot(endX, endY);

        // If startX == 9 it indicates a drop
        if(startX == 9){
            Move drop = new Move(player, null, endingSpot);
            boolean validDrop = makeDrop(drop, player.getCapturedPiece(startY), player, true);
            if (validDrop){
                player.deleteCapturedPiece(startY);
            }
            return validDrop;
        }

        Spot startingSpot = board.getSpot(startX, startY);

        //Validates the spots
        if (startingSpot == null || endingSpot == null){
            System.out.println("Those are not valid spot locations");
            return false;
        }

        //Validates that the move does not use the same starting and ending spot
        if (startingSpot == endingSpot){
            System.out.println("You cannot move a piece to the same place it's located");
            return false;
        }

        Move move = new Move(player, startingSpot, endingSpot);
        return makeMove(move, player);
    }

    /* VALIDATION OF DROP */

    private boolean makeDrop(Move drop, Piece piece, Player player, boolean verbose){


        //Validates that piece is selected
        if (piece == null){
            if (verbose){
                System.out.println("There's no piece on that spot");
            }
            return false;
        }

        //Validates if there's a piece on the dropping spot
        if (drop.getEndingSpot().getPiece() != null){
            if (verbose){
                System.out.println("You cannot drop a piece in a used spot");
            }
            return false;
        }

        //If it's a knight it can't be dropped on the last two ranks
        if (piece.getClass() == Knight.class){
            if (currentTurn.isBlack() && drop.getEndingSpot().getY() >= 7){
                if (verbose) {
                    System.out.println("Knights cannot be dropped on the two last ranks");
                }
                return false;
            } else if (!currentTurn.isBlack() && drop.getEndingSpot().getY() <= 1){
                if (verbose){
                    System.out.println("Knights cannot be dropped on the two last ranks");
                }
                return false;
            }
        }

        //If it's a lance or a pawn it can't be dropped on the last rank
        if (piece.getClass() == Lance.class || piece.getClass() == Pawn.class){
            if (currentTurn.isBlack() && drop.getEndingSpot().getY() == 8){
                if (verbose){
                    System.out.println("Lances and Pawns cannot be dropped on the last rank");
                }
                return false;
            } else if (!currentTurn.isBlack() && drop.getEndingSpot().getY() == 0){
                return false;
            }
        }

        //If it's a pawn it can't be dropped on a column where there's an unpromoted pawn of the same color
        //It also can't deliver instant checkmate
        if (piece.getClass() == Pawn.class){
            for (int i = 0; i < 9; i++){
                Piece checkPawn = board.getSpot(drop.getEndingSpot().getX(), i).getPiece();
                if (checkPawn != null && checkPawn.getClass() == Pawn.class && !checkPawn.isPromoted() && checkPawn.isBlack() == currentTurn.isBlack()){
                    if (verbose){
                        System.out.println("Pawns cannot be dropped on columns where there's already an unpromoted pawn");
                    }
                    return false;
                }
            }

            drop.getEndingSpot().setPiece(piece);
            piece.setCaptured(false);

            if (isCheckmate(currentTurn.isBlack())){
                drop.getEndingSpot().setPiece(null);
                piece.setCaptured(true);
                if (verbose) {
                    System.out.println("Pawns cannot be dropped to instantly provoke checkmate");
                }
                return false;
            }

            drop.getEndingSpot().setPiece(null);
            piece.setCaptured(true);
        }


        //Makes drop
        drop.getEndingSpot().setPiece(piece);
        piece.setCaptured(false);

        //Verifies if drop is invalid (The player was on check and the drop didn't prevent it)
        Spot currentKingSpot = board.getKingSpot(currentTurn.isBlack());
        King currentKing = (King) currentKingSpot.getPiece();
        if (currentKing.isAttacked(board, currentKingSpot)){
            if (verbose){
                System.out.println("You are still in check");
            }
            drop.getEndingSpot().setPiece(null);
            piece.setCaptured(true);
            return false;
        }

        //Deletes captured piece from player & adds move to game
        movesPlayed.add(drop);

        //Verifies if there's checkmate
        if (isCheckmate(drop.getPlayer().isBlack())){
            if (currentTurn.isBlack()){
                setStatus(GameStatus.BLACK_WIN);
                System.out.println("  +----------------------------+");
                System.out.println("  |                            |");
                System.out.println("  |          BLACK WON         |");
                System.out.println("  |                            |");
                System.out.println("  +----------------------------+");
                System.exit(0);
            } else if (!currentTurn.isBlack()){
                setStatus(GameStatus.WHITE_WIN);
                System.out.println("  +----------------------------+");
                System.out.println("  |                            |");
                System.out.println("  |          WHITE WON         |");
                System.out.println("  |                            |");
                System.out.println("  +----------------------------+");
                System.exit(0);
            }
        }

        //Changes players turn
        if (getCurrentTurn() == players[0]){
            setCurrentTurn(players[1]);
        } else {
            setCurrentTurn(players[0]);
        }

        return true;
    }

    /* PROMOTION */

    public void promote(int x, int y){
        board.getSpot(x, y).getPiece().setPromoted(true);
    }

    /* VALIDATION OF MOVE */

    private boolean makeMove(Move move, Player player){
        Piece piece = move.getStartingSpot().getPiece();

        //Validates if there's a piece selected
        if (piece == null){
            System.out.println("There's no piece on that spot");
            return false;
        }

        //Validates if piece belongs to player on turn
        if (piece.isBlack() != player.isBlack() || player != currentTurn){
            System.out.println("You can only move pieces that belong to you");
            return false;
        }

        //Validates if the move is valid for than piece on the current state of the board
        if (!piece.canMove(board, move.getStartingSpot(), move.getEndingSpot())){
            System.out.println("That's not a valid move");
            return false;
        }

        //Makes move
        Piece captured = move.getEndingSpot().getPiece();
        move.getEndingSpot().setPiece(move.getPieceMoved());
        move.getStartingSpot().setPiece(null);

        //Verifies that if the player was in check, the move prevented it
        Spot currentKingSpot = board.getKingSpot(currentTurn.isBlack());
        King currentKing = (King) currentKingSpot.getPiece();
        if (currentKing.isAttacked(board, currentKingSpot)){
            move.getStartingSpot().setPiece(move.getEndingSpot().getPiece());
            move.getEndingSpot().setPiece(captured);
            System.out.println("You are still in check");
            return false;
        }

        //Reverts move
        move.getStartingSpot().setPiece(move.getEndingSpot().getPiece());
        move.getEndingSpot().setPiece(captured);

        //If a piece was captured, adds it to the player capturedPiece list
        Piece destPiece = move.getEndingSpot().getPiece();
        if (destPiece != null) {
            destPiece.setCaptured(true);
            destPiece.setBlack(currentTurn.isBlack());
            destPiece.setPromoted(false);
            currentTurn.addCapturedPiece(destPiece);
        }

        //Makes move
        movesPlayed.add(move);
        move.getEndingSpot().setPiece(move.getPieceMoved());
        move.getStartingSpot().setPiece(null);

        //Verifies if there's checkmate
        if (isCheckmate(currentTurn.isBlack())){
            if (currentTurn.isBlack()){
                setStatus(GameStatus.BLACK_WIN);
                System.out.println("  +----------------------------+");
                System.out.println("  |                            |");
                System.out.println("  |          BLACK WON         |");
                System.out.println("  |                            |");
                System.out.println("  +----------------------------+");
                System.exit(0);
            } else if (!currentTurn.isBlack()){
                setStatus(GameStatus.WHITE_WIN);
                System.out.println("  +----------------------------+");
                System.out.println("  |                            |");
                System.out.println("  |          WHITE WON         |");
                System.out.println("  |                            |");
                System.out.println("  +----------------------------+");
                System.exit(0);
            }
        }

        //Changes players turn
        if (getCurrentTurn() == players[0]){
            setCurrentTurn(players[1]);
        } else {
            setCurrentTurn(players[0]);
        }

        return true;
    }

    /* CHECKMATE DETECTION */

    public boolean isCheckmate(boolean black){

        //Gets the spot and the piece of the king to verify if it's in checkmate
        Spot oppositeKingSpot = board.getKingSpot(!black);
        King oppositeKing = (King) oppositeKingSpot.getPiece();

        //If it's not attacked, it's not in checkmate
        if(!oppositeKing.isAttacked(board, oppositeKingSpot)){
            return false;
        }


        Spot[][] spots = board.getSpots();

        //Verifies if king has an available move
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (oppositeKing.canMove(board, oppositeKingSpot, spots[i][j])){
                    return false;
                }
            }
        }


        //TODO Improve efficiency of algorithm (Probably designing a solution using HashMaps)
        //Verifies if a piece on the board can block the check
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (spots[i][j].getPiece() != null && spots[i][j].getPiece().isBlack() != currentTurn.isBlack()){
                    for (int x = 0; x < 9; x++){
                        for (int y = 0; y < 9; y++){
                            if (spots[i][j].getPiece().canMove(board, spots[i][j], spots[x][y])){
                                Piece captured = spots[x][y].getPiece();
                                Piece moved = spots[i][j].getPiece();
                                spots[x][y].setPiece(moved);
                                spots[i][j].setPiece(null);

                                if(!oppositeKing.isAttacked(board, oppositeKingSpot)){
                                    spots[x][y].setPiece(captured);
                                    spots[i][j].setPiece(moved);
                                    return false;
                                }

                                spots[x][y].setPiece(captured);
                                spots[i][j].setPiece(moved);
                            }
                        }
                    }
                }
            }
        }


        Player defendingPlayer = players[0].isBlack() == black ? players[1] : players[0];


        for (Piece piece : defendingPlayer.getCapturedPieces()){
            for (int x = 0; x < 9; x++){
                for(int j = 0; j < 9; j++){
                    if (makeDrop(new Move(defendingPlayer, null, spots[x][j]), piece, defendingPlayer, false)){
                        if(!oppositeKing.isAttacked(board, oppositeKingSpot)){
                            spots[x][j].setPiece(null);
                            piece.setCaptured(true);
                            movesPlayed.remove(movesPlayed.size()-1);
                            return false;
                        }
                        spots[x][j].setPiece(null);
                        piece.setCaptured(true);
                        movesPlayed.remove(movesPlayed.size()-1);
                    }
                }
            }
        }

        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Move getLastMove(){
        return this.movesPlayed.get(movesPlayed.size() - 1);
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
