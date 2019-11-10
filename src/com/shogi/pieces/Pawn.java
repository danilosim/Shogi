package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Pawn extends Piece {

    public Pawn(boolean black) {
        super(black, black ? "P^" : "Pv");
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

}
