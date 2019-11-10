package com.shogi;

import com.shogi.pieces.*;

public class Board {
    private Spot[][] spots = new Spot[9][9];

    public Spot getSpot(int x, int y){
        if(x < 0 || x > 8 || y < 0 || y > 8){
            return null;
        }
        return spots[x][y];
    }

    public Board(){
        fillSpots();
    }

    private void fillSpots(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                spots[i][j] = new Spot(i, j);
            }
        }
    }

    //Initialize
    public void initialize(){

        //Kings
        this.spots[4][0].setPiece(new King(true));
        this.spots[4][8].setPiece(new King(false));

        //Pawns
        for (int i = 0; i < 9; i++){
            this.spots[i][2].setPiece(new Pawn(true));
            this.spots[i][6].setPiece(new Pawn(false));
        }

        //Lances
        this.spots[0][0].setPiece(new Lance(true));
        this.spots[8][0].setPiece(new Lance(true));
        this.spots[0][8].setPiece(new Lance(false));
        this.spots[8][8].setPiece(new Lance(false));

        //Knights
        this.spots[1][0].setPiece(new Knight(true));
        this.spots[7][0].setPiece(new Knight(true));
        this.spots[1][8].setPiece(new Knight(false));
        this.spots[7][8].setPiece(new Knight(false));

        //Silver Generals
        this.spots[2][0].setPiece(new SilverGeneral(true));
        this.spots[6][0].setPiece(new SilverGeneral(true));
        this.spots[2][8].setPiece(new SilverGeneral(false));
        this.spots[6][8].setPiece(new SilverGeneral(false));

        //Golden Generals
        this.spots[3][0].setPiece(new GoldGeneral(true));
        this.spots[5][0].setPiece(new GoldGeneral(true));
        this.spots[3][8].setPiece(new GoldGeneral(false));
        this.spots[5][8].setPiece(new GoldGeneral(false));

        //Rooks
        this.spots[7][1].setPiece(new Rook(true));
        this.spots[1][7].setPiece(new Rook(false));

        //Bishops
        this.spots[1][1].setPiece(new Bishop(true));
        this.spots[7][7].setPiece(new Bishop(false));


    }

    public void printBoard(){
        System.out.println("  +----------------------------+");
        for (int i = 8; i > -1; i--){
            System.out.print(i + " ");
            System.out.print("| ");
            for (int j = 0; j < 9; j++){
                System.out.print(spots[j][i].getId() + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("  +----------------------------+");
        System.out.println("    0  1  2  3  4  5  6  7  8");
    }

    public void setSpot(Piece piece, int x, int y){
        this.spots[x][y].setPiece(piece);
    }
}
