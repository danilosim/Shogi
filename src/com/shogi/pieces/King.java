package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class King extends Piece {

    public King(boolean black) {
        super(black, black ? "K^" : "Kv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if (startingSpot == null || endingSpot == null){
            return false;
        }

        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == this.isBlack()){
            return false;
        }

        int x = Math.abs(startingSpot.getX() - endingSpot.getX());
        int y = Math.abs(startingSpot.getY() - endingSpot.getY());
        if (x <= 1 && y <= 1){
            return !isAttacked(board, endingSpot);
        }

        return false;
    }

    public boolean isAttacked(Board board, Spot spot){
        //TODO
        return false;
    }
}
