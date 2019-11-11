package com.shogi;

public abstract class Piece {
    protected boolean black;
    protected boolean captured;
    protected String id;
    protected String baseId;

    public Piece (boolean black){
        this.black = black;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }
}
