package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class SilverGeneral extends Piece {

    public SilverGeneral(boolean black) {
        super(black, black ? "S^" : "Sv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {

        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        int distY = Math.abs(startingSpot.getY() - endingSpot.getY());
        int distX = Math.abs(startingSpot.getX() - endingSpot.getX());

        if(distX == 1 && distY == 1){
            return true;
        }

        if(startingSpot.getPiece().isBlack()){
            if (startingSpot.getY() == endingSpot.getY() - 1 && distX == 0){
                return true;
            }
        }

        if(!startingSpot.getPiece().isBlack()){
            if (startingSpot.getY() == endingSpot.getY() + 1 && distX == 0){
                return true;
            }
        }

        return false;
    }
}
