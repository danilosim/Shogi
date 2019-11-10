package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private final Board board = new Board();

    @Test
    void moveBishopFreeBoard(){
        Bishop bishop = new Bishop(true);
        board.setSpot(bishop, 4,6);

        //Positives
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(6,8)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(6,4)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(7,3)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(8,2)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(2,8)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(2,4)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(1,3)));
        assertTrue(bishop.canMove(board, board.getSpot(4,6), board.getSpot(0,2)));

        //Negatives
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(4, 1)));
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(6, 6)));
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(2, 6)));
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(3, 4)));
        assertFalse(bishop.canMove(board, board.getSpot(4,6), board.getSpot(0, 8)));
    }

    @Test
    void moveBishopFilledBoard(){
        Bishop bishop = new Bishop(true);
        board.setSpot(bishop, 4,3);
        board.initialize();

        //Positives
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(5,4)));
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(6,5)));
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(7,6)));
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(3,4)));
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(2,5)));
        assertTrue(bishop.canMove(board, board.getSpot(4, 3), board.getSpot(1,6)));

        //Negatives
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(8,7)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(0,7)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(3,2)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(2,1)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(1,0)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(5,2)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(6,1)));
        assertFalse(bishop.canMove(board, board.getSpot(4,3), board.getSpot(7,0)));

    }
}