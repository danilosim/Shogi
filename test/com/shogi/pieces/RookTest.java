package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    private final Board board = new Board();

    @Test
    void moveRookFreeBoard(){
        Rook rook = new Rook(true);
        board.setSpot(rook, 4,6);

        //Positives
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,0)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,1)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,2)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,3)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,8)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(0,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(1,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(2,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(6,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(7,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(8,6)));

        //Negatives
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,8)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(0,0)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(7,1)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
    }

    @Test
    void moveRookFilledBoard(){
        Rook rook = new Rook(true);
        board.setSpot(rook, 4,3);
        board.initialize();

        //Positives
        assertTrue(rook.canMove(board, board.getSpot(4, 3), board.getSpot(4,4)));
        assertTrue(rook.canMove(board, board.getSpot(4, 3), board.getSpot(4,5)));
        assertTrue(rook.canMove(board, board.getSpot(4, 3), board.getSpot(4,6)));

        //Negatives
        assertFalse(rook.canMove(board, board.getSpot(4,3), board.getSpot(4,2)));
        assertFalse(rook.canMove(board, board.getSpot(4,3), board.getSpot(4,1)));
        assertFalse(rook.canMove(board, board.getSpot(4,3), board.getSpot(4,0)));
        assertFalse(rook.canMove(board, board.getSpot(4,3), board.getSpot(4,7)));
        assertFalse(rook.canMove(board, board.getSpot(4,3), board.getSpot(4,8)));

    }

    @Test
    void movePromotedRookFreeBoard(){
        Rook rook = new Rook(true);
        rook.setPromoted(true);
        board.setSpot(rook, 4,6);

        //Positives
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,0)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,1)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,2)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,3)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(4,8)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(0,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(1,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(2,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(6,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(7,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(8,6)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(rook.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));

        //Negatives
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(5,8)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(0,0)));
        assertFalse(rook.canMove(board, board.getSpot(4,6), board.getSpot(7,1)));
    }
}