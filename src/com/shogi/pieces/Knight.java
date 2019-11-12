package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Knight extends Piece {

    private final String baseId = "n";
    private final String promotedId = "N";

    public Knight(boolean black) {
        super(black);
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        if (this.isPromoted){
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
        } else {
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


    public String getId(){
        if (this.isPromoted){
            return this.promotedId + (this.isBlack() ? "^" : "v");
        } else {
            return this.baseId + (this.isBlack() ? "^" : "v");
        }
    }

}
