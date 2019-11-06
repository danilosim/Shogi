package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class SilverGeneral extends Piece {

    public SilverGeneral(boolean black) {
        super(black, black ? "S^" : "Sv");
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {
        return false;
    }
}
