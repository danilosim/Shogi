package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Knight extends Piece {

    private final String baseId = "n";
    private final String promotedId = "N";
    private boolean isPromoted = false;

    public Knight(boolean black) {
        super(black);
        this.id = baseId + (this.black ? "^" : "v");
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
