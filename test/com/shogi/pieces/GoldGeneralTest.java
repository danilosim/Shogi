package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldGeneralTest {

    private final Board board = new Board();

    @Test
    void moveBlackGoldGeneralFreeBoard(){
        GoldGeneral goldGeneral = new GoldGeneral(true);
        board.setSpot(goldGeneral, 4,6);

        //Positives
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));


        //Negatives
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(8,8)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveWhiteGoldGeneralFreeBoard(){
        GoldGeneral goldGeneral = new GoldGeneral(false);
        board.setSpot(goldGeneral, 4,6);

        //Positives
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));


        //Negatives
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(8,8)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveBlackGoldGeneralFilledBoard(){

        GoldGeneral goldGeneral = new GoldGeneral(true);
        board.initialize();
        board.setSpot(goldGeneral, 4,3);

        //Positives
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(3,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(4,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(5,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(3,3)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(5,3)));


        //Negatives
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,3), board.getSpot(4,2)));
    }

    @Test
    void moveWhiteGoldGeneralFilledBoard(){
        GoldGeneral goldGeneral = new GoldGeneral(false);
        board.initialize();
        board.setSpot(goldGeneral, 4,5);

        //Positives
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(3,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(4,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(5,4)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(3,5)));
        assertTrue(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(5,5)));


        //Negatives
        assertFalse(goldGeneral.canMove(board, board.getSpot(4,5), board.getSpot(4,6)));
    }
}