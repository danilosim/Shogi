package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Bishop extends Piece {

    public Bishop(boolean black) {
        super(black, black ? "B^" : "Bv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        return false;
    }
}
