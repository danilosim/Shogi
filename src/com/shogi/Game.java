package com.shogi;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player[] players = new Player[2];
    private Board board;
    private Player currentTurn;
    private List<Move> movesPlayed = new ArrayList<>();

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
        Spot startingSpot = board.getSpot(startX, startY);
        Spot endingSpot = board.getSpot(endX, endY);
        if (startingSpot == null || endingSpot == null){
            return false;
        }
        if (startingSpot == endingSpot){
            return false;
        }
        Move move = new Move(player, startingSpot, endingSpot);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player){
        Piece piece = move.getStartingSpot().getPiece();
        if (piece == null || piece.isBlack() != player.isBlack() || player != currentTurn){
//            System.out.println("You can only move pieces that belong to you");
            return false;
        }

        if (!piece.canMove(board, move.getStartingSpot(), move.getEndingSpot())){
//            System.out.println("That is not a valid move");
            return false;
        }

        Piece destPiece = move.getEndingSpot().getPiece();
        if (destPiece != null) {
            destPiece.setCaptured(true);
            move.setPieceCaptured(destPiece);
        }

        movesPlayed.add(move);
        move.getEndingSpot().setPiece(move.getStartingSpot().getPiece());
        move.getStartingSpot().setPiece(null);

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
}
