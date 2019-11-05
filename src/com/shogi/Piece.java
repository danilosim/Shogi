package com.shogi;

public abstract class Piece {
    private String name;
    private boolean black;
    private boolean captured;

    public Piece (boolean black){
        this.black = black;
    }

    public boolean isBlack(){
        return black;
    }

    public void setBlack(boolean black){
        this.black = black;
    }

    public boolean isCaptured(){
        return this.captured;
    }

    public void setCaptured(boolean captured){
        this.captured = captured;
    }

    public abstract boolean canMove(Board board, Spot startingSpot, Spot endingSpot);

}
