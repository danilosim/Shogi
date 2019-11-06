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
        return false;
    }
}
