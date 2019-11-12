package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Rook extends Piece {

    private final String baseId = "r";
    private final String promotedId = "R";

    public Rook(boolean black) {
        super(black);
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == startingSpot.getPiece().isBlack()){
            return false;
        }

        if (this.isPromoted){
            int distX = Math.abs(endingSpot.getX() - startingSpot.getX());
            int distY = Math.abs(endingSpot.getY() - startingSpot.getY());
            if (distX + distY == 2){
                return true;
            }
        }

        if(endingSpot.getX() == startingSpot.getX()){
            if (endingSpot.getY() > startingSpot.getY()){
                for (int i=endingSpot.getY()-startingSpot.getY()-1; i > 0; i--){
                    if(board.getSpot(startingSpot.getX(), startingSpot.getY()+i).getPiece() != null){
                        return false;
                    }
                }
            } else {
                for (int i=startingSpot.getY()-endingSpot.getY()-1; i > 0; i--){
                    if(board.getSpot(startingSpot.getX(), endingSpot.getY()+i).getPiece() != null){
                        return false;
                    }
                }
            }
            return true;
        } else if (endingSpot.getY() == startingSpot.getY()){
            if (endingSpot.getX() > startingSpot.getX()){
                for (int i=endingSpot.getX()-startingSpot.getX()-1; i > 0; i--){
                    if(board.getSpot(startingSpot.getX()+i, startingSpot.getY()).getPiece() != null){
                        return false;
                    }
                }
            } else {
                for (int i=startingSpot.getX()-endingSpot.getX()-1; i > 0; i--){
                    if(board.getSpot(startingSpot.getX()+i, endingSpot.getY()).getPiece() != null){
                        return false;
                    }
                }
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
