package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Bishop extends Piece {

    private final String baseId = "b";
    private final String promotedId = "B";
    private boolean isPromoted = false;

    public Bishop(boolean black) {
        super(black);
        this.id = baseId + (this.black ? "^" : "v");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }
        int xDifference = endingSpot.getX() - startingSpot.getX();
        if (endingSpot.getY() == startingSpot.getY() + xDifference || endingSpot.getY() == startingSpot.getY() - xDifference){
            int yDifference = endingSpot.getY() - startingSpot.getY();
            int i = Math.abs(xDifference) - 1;
            int x = startingSpot.getX();
            int y = startingSpot.getY();
            while (i != 0){
                if(xDifference > 0 && yDifference > 0){
                    if(board.getSpot(++x, ++y).getPiece() != null){
                        return false;
                    }
                } else if(xDifference > 0 && yDifference < 0){
                    if(board.getSpot(++x, --y).getPiece() != null){
                        return false;
                    }
                } else if(xDifference < 0 && yDifference > 0){
                    if(board.getSpot(--x, ++y).getPiece() != null){
                        return false;
                    }
                } else {
                    if(board.getSpot(--x, --y).getPiece() != null){
                        return false;
                    }
                }
                i--;
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
