package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class GoldGeneral extends Piece {

    public GoldGeneral(boolean black) {
        super(black, black ? "G^" : "Gv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        return false;
    }
}
