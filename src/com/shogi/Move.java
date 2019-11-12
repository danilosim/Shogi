package com.shogi;

public class Move {

    private Player player;
    private Spot startingSpot;
    private Spot endingSpot;
    private Piece pieceMoved;
    private Piece pieceCaptured;

    public Move(Player player, Spot startingSpot, Spot endingSpot){
        this.player = player;
        this.startingSpot = startingSpot;
        this.endingSpot = endingSpot;
        this.pieceMoved = startingSpot != null ? startingSpot.getPiece() : null;
        this.pieceCaptured = endingSpot.getPiece();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getStartingSpot() {
        return startingSpot;
    }

    public void setStartingSpot(Spot startingSpot) {
        this.startingSpot = startingSpot;
    }

    public Spot getEndingSpot() {
        return endingSpot;
    }

    public void setEndingSpot(Spot endingSpot) {
        this.endingSpot = endingSpot;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceCaptured() {
        return pieceCaptured;
    }

    public void setPieceCaptured(Piece pieceCaptured) {
        this.pieceCaptured = pieceCaptured;
    }
}
