package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Lance extends Piece {

    private final String baseId = "l";
    private final String promotedId = "L";
    private boolean isPromoted = false;

    public Lance(boolean black) {
        super(black);
        this.id = baseId + (this.black ? "^" : "v");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        if(startingSpot.getPiece().isBlack() && startingSpot.getX() == endingSpot.getX() && startingSpot.getY() < endingSpot.getY()){
            int distY = endingSpot.getY() - startingSpot.getY() - 1;
            while (distY != 0){
                if (board.getSpot(startingSpot.getX(), startingSpot.getY() + distY).getPiece() != null){
                    return false;
                }
                distY--;
            }
            return true;
        }

        if(!startingSpot.getPiece().isBlack() && startingSpot.getX() == endingSpot.getX() && startingSpot.getY() > endingSpot.getY()){
            int distY = startingSpot.getY() - endingSpot.getY() - 1;
            while (distY != 0){
                if (board.getSpot(startingSpot.getX(), endingSpot.getY() + distY).getPiece() != null){
                    return false;
                }
                distY--;
            }
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
