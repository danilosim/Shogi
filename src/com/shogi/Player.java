package com.shogi;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private boolean blackSide;
    private List<Piece> capturedPieces = new ArrayList<>();

    public Player (boolean blackSide){
        this.blackSide = blackSide;
    }


    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public void setCapturedPieces(List<Piece> capturedPieces) {
        this.capturedPieces = capturedPieces;
    }

    public void addCapturedPiece(Piece piece){
        capturedPieces.add(piece);
    }

    public Piece getCapturedPiece(int number){
        try {
            Piece piece = capturedPieces.get(number);
            return piece;
        }catch (IndexOutOfBoundsException e){
            return null;
        }

    }

    public void deleteCapturedPiece(int number){
        capturedPieces.remove(capturedPieces.get(number));
    }

    public boolean isBlack(){
        return this.blackSide;
    }

    public void setBlackSide(boolean blackSide){
        this.blackSide = blackSide;
    }

}
