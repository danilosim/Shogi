package com.shogi.pieces;

import com.shogi.Board;
import com.shogi.Piece;
import com.shogi.Spot;

public class King extends Piece {

    private final String baseId = "K";

    public King(boolean black) {
        super(black);
    }

    @Override
    public boolean canMove(Board board, Spot startingSpot, Spot endingSpot) {

        if(endingSpot.getPiece() != null && endingSpot.getPiece().isBlack() == this.isBlack()){
            return false;
        }

        int x = Math.abs(startingSpot.getX() - endingSpot.getX());
        int y = Math.abs(startingSpot.getY() - endingSpot.getY());
        if (x <= 1 && y <= 1){
            return !isAttacked(board, endingSpot);
        }

        return false;
    }

    public boolean isAttacked(Board board, Spot spot){
        Spot[][] spots = board.getSpots();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(spots[i][j].getPiece() != null){
                    if(spots[i][j].getPiece().isBlack() != this.isBlack()){
                        if (spots[i][j].getPiece().canMove(board, board.getSpot(i, j), spot)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getId(){
        return this.baseId + (this.isBlack() ? "^" : "v");
    }

}
