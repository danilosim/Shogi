package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Knight extends Piece {

    public Knight(boolean black) {
        super(black, black ? "N^" : "Nv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        int distX = endingSpot.getX() - startingSpot.getX();
        int distY = endingSpot.getY() - startingSpot.getY();

        if(startingSpot.getPiece().isBlack() && Math.abs(distX) == 1 && distY == 2){
            return true;
        }

        if(!startingSpot.getPiece().isBlack() && Math.abs(distX) == 1 && distY == -2){
            return true;
        }

        return false;
    }
}
