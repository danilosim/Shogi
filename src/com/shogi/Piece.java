package com.shogi;

public abstract class Piece {
    protected boolean black;
    protected boolean captured;
    protected boolean isPromoted = false;

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

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    public abstract String getId();
}
