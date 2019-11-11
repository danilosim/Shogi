package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Pawn extends Piece {

    private final String baseId = "p";
    private final String promotedId = "P";
    private boolean isPromoted = false;

    public Pawn(boolean black) {
        super(black);
        this.id = baseId + (this.black ? "^" : "v");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if (endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }
        if (startingSpot.getX() == endingSpot.getX()){
            if((startingSpot.getPiece().isBlack() && startingSpot.getY() + 1 == endingSpot.getY()) || (!startingSpot.getPiece().isBlack() && startingSpot.getY() - 1 == endingSpot.getY())){
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
