package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Pawn extends Piece {

    private final String baseId = "p";
    private final String promotedId = "P";

    public Pawn(boolean black) {
        super(black);
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if (endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
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
            if (startingSpot.getX() == endingSpot.getX()){
                if((startingSpot.getPiece().isBlack() && startingSpot.getY() + 1 == endingSpot.getY()) || (!startingSpot.getPiece().isBlack() && startingSpot.getY() - 1 == endingSpot.getY())){
                    return true;
                }
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
