package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class GoldGeneral extends Piece {

    public GoldGeneral(boolean black) {
        super(black, black ? "G^" : "Gv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        int distY = Math.abs(startingSpot.getY() - endingSpot.getY());
        int distX = Math.abs(startingSpot.getX() - endingSpot.getX());

        if(distX + distY == 1){
            return true;
        }

        if(startingSpot.getPiece().isBlack()){
            if (startingSpot.getY() == endingSpot.getY() - 1 && distX == 1){
                return true;
            }
        }

        if(!startingSpot.getPiece().isBlack()){
            if (startingSpot.getY() == endingSpot.getY() + 1 && distX == 1){
                return true;
            }
        }

        return false;
    }
}
