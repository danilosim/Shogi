package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Lance extends Piece {

    public Lance(boolean black) {
        super(black, black ? "L^" : "Lv");
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
}
