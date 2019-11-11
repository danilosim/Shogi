package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class SilverGeneral extends Piece {

    private final String baseId = "s";
    private final String promotedId = "S";
    private boolean isPromoted = false;

    public SilverGeneral(boolean black) {
        super(black);
        this.id = baseId + (this.black ? "^" : "v");
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

    public String getBaseId() {
        return baseId;
    }

    public String getPromotedId() {
        return promotedId;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }
}
