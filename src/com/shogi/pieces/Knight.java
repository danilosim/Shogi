package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class Knight extends Piece {

    public Knight(boolean black) {
        super(black, black ? "N^" : "Nv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        return false;
    }
}
