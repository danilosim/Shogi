package com.shogi;

public class Player {

    private boolean blackSide;

    public Player (boolean blackSide){
        this.blackSide = blackSide;
    }

    public boolean isBlack(){
        return this.blackSide;
    }

    public void setBlackSide(boolean blackSide){
        this.blackSide = blackSide;
    }

}
