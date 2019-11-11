package com.shogi;

public class Drop {

    private Player player;
    private Spot endingSpot;

    public Drop(Player player, Spot endingSpot){
        this.player = player;
        this.endingSpot = endingSpot;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getEndingSpot() {
        return endingSpot;
    }

    public void setEndingSpot(Spot endingSpot) {
        this.endingSpot = endingSpot;
    }

}
