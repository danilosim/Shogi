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

    public void initialize(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;

        board = new Board();
        board.initialize();

        if (p1.isBlack()){
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY){


        Spot endingSpot = board.getSpot(endX, endY);

        if(startX == 9){
            Move drop = new Move(player, null, endingSpot);
            return this.makeDrop(drop, startY, player);
        }

        Spot startingSpot = board.getSpot(startX, startY);
        if (startingSpot == null || endingSpot == null){
            return false;
        }
        if (startingSpot == endingSpot){
            return false;
        }

        Move move = new Move(player, startingSpot, endingSpot);
        return this.makeMove(move, player);
    }

    private boolean makeDrop(Move drop, int pieceNumber, Player player){

        Piece piece = player.getCapturedPiece(pieceNumber);

        if (piece == null){
            System.out.println("There's no piece on that spot");
            return false;
        }

        if (drop.getEndingSpot().getPiece() != null){
            System.out.println("You cannot drop a piece in a used spot");
            return false;
        }

        if (piece.getClass() == Knight.class){
            if (currentTurn.isBlack() && drop.getEndingSpot().getY() >= 7){
                return false;
            } else if (!currentTurn.isBlack() && drop.getEndingSpot().getY() <= 1){
                return false;
            }
        }

        if (piece.getClass() == Lance.class || piece.getClass() == Pawn.class){
            if (currentTurn.isBlack() && drop.getEndingSpot().getY() == 8){
                return false;
            } else if (!currentTurn.isBlack() && drop.getEndingSpot().getY() == 0){
                return false;
            }
        }

        if (piece.getClass() == Pawn.class){
            for (int i = 0; i < 9; i++){
                Piece checkPawn = board.getSpot(drop.getEndingSpot().getX(), i).getPiece();
                if (checkPawn != null && checkPawn.getClass() == Pawn.class && !checkPawn.isPromoted() && checkPawn.isBlack() == currentTurn.isBlack()){
                    return false;
                }
            }

            drop.getEndingSpot().setPiece(piece);
            piece.setCaptured(false);

            if (board.isCheckmate(currentTurn.isBlack())){
                drop.getEndingSpot().setPiece(null);
                piece.setCaptured(true);
                return false;
            }

            drop.getEndingSpot().setPiece(null);
            piece.setCaptured(true);
        }

        drop.getEndingSpot().setPiece(piece);
        piece.setCaptured(false);
        player.deleteCapturedPiece(pieceNumber);
        movesPlayed.add(drop);

        if (board.isCheckmate(currentTurn.isBlack())){
            if (currentTurn.isBlack()){
                this.status = GameStatus.BLACK_WIN;
                System.out.println("Black won");
                System.exit(0);
            } else if (!currentTurn.isBlack()){
                this.status = GameStatus.WHITE_WIN;
                System.out.println("White won");
                System.exit(0);
            }
        }

        if (this.currentTurn == players[0]){
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }

        return true;
    }

    public void promote(int x, int y){
        this.board.getSpot(x, y).getPiece().setPromoted(true);
    }

    private boolean makeMove(Move move, Player player){
        Piece piece = move.getStartingSpot().getPiece();

        if (piece == null){
            System.out.println("There's no piece on that spot");
            return false;
        }

        if (piece.isBlack() != player.isBlack() || player != currentTurn){
            System.out.println("You can only move pieces that belong to you");
            return false;
        }

        if (!piece.canMove(board, move.getStartingSpot(), move.getEndingSpot())){
            return false;
        }

        Piece captured = move.getEndingSpot().getPiece();
        move.getEndingSpot().setPiece(move.getPieceMoved());
        move.getStartingSpot().setPiece(null);

        Spot currentKingSpot = board.getKing(currentTurn.isBlack());
        King currentKing = (King) currentKingSpot.getPiece();
        if (currentKing.isAttacked(board, currentKingSpot)){
            move.getStartingSpot().setPiece(move.getEndingSpot().getPiece());
            move.getEndingSpot().setPiece(captured);
            return false;
        }

        move.getStartingSpot().setPiece(move.getEndingSpot().getPiece());
        move.getEndingSpot().setPiece(captured);


        Piece destPiece = move.getEndingSpot().getPiece();
        if (destPiece != null) {
            destPiece.setCaptured(true);
            destPiece.setBlack(currentTurn.isBlack());
            destPiece.setPromoted(false);
            currentTurn.addCapturedPiece(destPiece);
        }

        movesPlayed.add(move);
        move.getEndingSpot().setPiece(move.getPieceMoved());
        move.getStartingSpot().setPiece(null);

        if (board.isCheckmate(currentTurn.isBlack())){
            if (currentTurn.isBlack()){
                this.status = GameStatus.BLACK_WIN;
                System.out.println("Black won");
                System.exit(0);
            } else if (!currentTurn.isBlack()){
                this.status = GameStatus.WHITE_WIN;
                System.out.println("White won");
                System.exit(0);
            }
        }

        if (this.currentTurn == players[0]){
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
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
}
