package com.shogi;

public abstract class Piece {
    private String name;
    private boolean black;
    private boolean captured;
    private String id;

    public Piece (boolean black, String id){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
