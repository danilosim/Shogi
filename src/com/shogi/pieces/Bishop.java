package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Bishop extends Piece {

    private final String baseId = "b";
    private final String promotedId = "B";

    public Bishop(boolean black) {
        super(black);
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        if(this.isPromoted){
            int distX = Math.abs(startingSpot.getX() - endingSpot.getX());
            int distY = Math.abs(startingSpot.getY() - endingSpot.getY());
            if(distX + distY == 1){
                return true;
            }
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

    public String getId(){
        if (this.isPromoted){
            return this.promotedId + (this.isBlack() ? "^" : "v");
        } else {
            return this.baseId + (this.isBlack() ? "^" : "v");
        }
    }

}
