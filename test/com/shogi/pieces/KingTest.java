package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    private final Board board = new Board();

    @Test
    void moveKingFreeBoard(){
        King king = new King(true);
        board.setSpot(king, 4,6);

        //Positives
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(king.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));

        //Negatives
        assertFalse(king.canMove(board, board.getSpot(4,6), board.getSpot(2,8)));
        assertFalse(king.canMove(board, board.getSpot(4,6), board.getSpot(4,0)));
        assertFalse(king.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertFalse(king.canMove(board, board.getSpot(4,6), board.getSpot(2,3)));
        assertFalse(king.canMove(board, board.getSpot(4,6), board.getSpot(7,8)));
    }

    @Test
    void moveKingFilledBoard(){

        King king = new King(true);
        board.initialize();
        board.setSpot(king, 4,4);

        //Positives
        assertTrue(king.canMove(board, board.getSpot(4,4), board.getSpot(3,4)));
        assertTrue(king.canMove(board, board.getSpot(4,4), board.getSpot(5,4)));
        assertTrue(king.canMove(board, board.getSpot(4,4), board.getSpot(3,3)));
        assertTrue(king.canMove(board, board.getSpot(4,4), board.getSpot(4,3)));
        assertTrue(king.canMove(board, board.getSpot(4,4), board.getSpot(5,3)));

        //Negatives
        assertFalse(king.canMove(board, board.getSpot(4,4), board.getSpot(3,5)));
        assertFalse(king.canMove(board, board.getSpot(4,4), board.getSpot(4,5)));
        assertFalse(king.canMove(board, board.getSpot(4,4), board.getSpot(5,5)));
    }

}