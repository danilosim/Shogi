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
        return false;
    }
}
