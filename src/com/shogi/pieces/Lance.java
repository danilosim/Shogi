package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Lance extends Piece {

    private final String baseId = "l";
    private final String promotedId = "L";

    public Lance(boolean black) {
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

    }

    public String getId(){
        if (this.isPromoted){
            return this.promotedId + (this.isBlack() ? "^" : "v");
        } else {
            return this.baseId + (this.isBlack() ? "^" : "v");
        }
    }

}
