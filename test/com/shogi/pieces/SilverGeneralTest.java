package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SilverGeneralTest {

    private final Board board = new Board();

    @Test
    void moveBlackSilverGeneralFreeBoard(){
        SilverGeneral silverGeneral = new SilverGeneral(true);
        board.setSpot(silverGeneral, 4,6);

        //Positives
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));


        //Negatives
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveWhiteSilverGeneralFreeBoard(){
        SilverGeneral silverGeneral = new SilverGeneral(false);
        board.setSpot(silverGeneral, 4,6);

        //Positives
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));


        //Negatives
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveBlackSilverGeneralFilledBoard(){

        SilverGeneral silverGeneral = new SilverGeneral(true);
        board.initialize();
        board.setSpot(silverGeneral, 4,3);

        //Positives
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,3), board.getSpot(3,4)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,3), board.getSpot(4,4)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,3), board.getSpot(5,4)));


        //Negatives
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,3), board.getSpot(3,2)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,3), board.getSpot(5,2)));
    }

    @Test
    void moveWhiteSilverGeneralFilledBoard(){
        SilverGeneral silverGeneral = new SilverGeneral(false);
        board.initialize();
        board.setSpot(silverGeneral, 4,5);

        //Positives
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,5), board.getSpot(3,4)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,5), board.getSpot(4,4)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,5), board.getSpot(5,4)));

        //Negatives
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,5), board.getSpot(3,6)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,5), board.getSpot(5,6)));
    }

    void movePromotedSilverGeneralFreeBoard(){
        SilverGeneral silverGeneral = new SilverGeneral(true);
        silverGeneral.setPromoted(true);
        board.setSpot(silverGeneral, 4,6);

        //Positives
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));


        //Negatives
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(8,8)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(silverGeneral.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

}