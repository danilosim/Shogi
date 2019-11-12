package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private final Board board = new Board();

    @Test
    void moveBlackPawnFreeBoard(){
        Pawn pawn = new Pawn(true);
        board.setSpot(pawn, 4,6);

        //Positives
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));

        //Negatives
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,8)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(2,3)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(7,8)));
    }

    @Test
    void moveWhitePawnFreeBoard(){
        Pawn pawn = new Pawn(false);
        board.setSpot(pawn, 4,6);

        //Positives
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));

        //Negatives
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,4)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,8)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(2,3)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(7,8)));
    }

    @Test
    void moveBlackPawnFilledBoard(){

        Pawn pawn = new Pawn(true);
        board.initialize();
        board.setSpot(pawn, 4,5);

        //Positives
        assertTrue(pawn.canMove(board, board.getSpot(4,5), board.getSpot(4,6)));

        //Negatives
        assertFalse(pawn.canMove(board, board.getSpot(4,5), board.getSpot(4,4)));
    }

    @Test
    void moveWhitePawnFilledBoard(){
        Pawn pawn = new Pawn(false);
        board.initialize();
        board.setSpot(pawn, 4,3);

        //Positives
        assertTrue(pawn.canMove(board, board.getSpot(4,3), board.getSpot(4,2)));

        //Negatives
        assertFalse(pawn.canMove(board, board.getSpot(4,3), board.getSpot(4,4)));
    }

    void movePromotedPawnFreeBoard(){
        Pawn pawn = new Pawn(true);
        pawn.setPromoted(true);
        board.setSpot(pawn, 4,6);

        //Positives
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,7)));
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(4,5)));
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(3,6)));
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(3,7)));
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(5,6)));
        assertTrue(pawn.canMove(board, board.getSpot(4,6), board.getSpot(5,7)));


        //Negatives
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(3,5)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(5,5)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(8,8)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(0,1)));
        assertFalse(pawn.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }
}