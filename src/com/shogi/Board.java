package com.shogi;

public class Board {
    private Spot[][] spots;

    public Board(){
        this.newBoard();
    }

    public Spot getSpot(int x, int y) throws Exception {
        if(x < 0 || x > 8 || y < 0 || y > 8){
            throw new Exception("Index out of bounds");
        }
        return spots[x][y];
    }

    public void newBoard(){

    }
}
