package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanceTest {

    private final Board board = new Board();

    @Test
    void moveBlackLanceFreeBoard(){
        Lance lance = new Lance(true);
        board.setSpot(lance, 4,3);

        //Positives
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,4)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,5)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,6)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,7)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,8)));


        //Negatives
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,2)));
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,1)));
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,0)));
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(2,1)));
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(7,7)));
    }

    @Test
    void moveWhiteLanceFreeBoard(){
        Lance lance = new Lance(false);
        board.setSpot(lance, 4,6);

        //Positives
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,3)));
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,2)));
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,1)));
        assertTrue(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,0)));


        //Negatives
        assertFalse(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertFalse(lance.canMove(board, board.getSpot(4,6), board.getSpot(4,8)));
        assertFalse(lance.canMove(board, board.getSpot(4,6), board.getSpot(8,8)));
        assertFalse(lance.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(lance.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveBlackLanceFilledBoard(){

        Lance lance = new Lance(true);
        board.initialize();
        board.setSpot(lance, 4,3);

        //Positives
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,4)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,5)));
        assertTrue(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,6)));

        //Negatives
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,7)));
        assertFalse(lance.canMove(board, board.getSpot(4,3), board.getSpot(4,8)));
    }

    @Test
    void moveWhiteLanceFilledBoard(){
        Lance lance = new Lance(false);
        board.initialize();
        board.setSpot(lance, 4,5);

        //Positives
        assertTrue(lance.canMove(board, board.getSpot(4,5), board.getSpot(4,4)));
        assertTrue(lance.canMove(board, board.getSpot(4,5), board.getSpot(4,3)));
        assertTrue(lance.canMove(board, board.getSpot(4,5), board.getSpot(4,2)));

        //Negatives
        assertFalse(lance.canMove(board, board.getSpot(4,5), board.getSpot(4,1)));
        assertFalse(lance.canMove(board, board.getSpot(4,5), board.getSpot(4,0)));
    }

}