package com.shogi.pieces;

import com.shogi.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private final Board board = new Board();

    @Test
    void moveBlackKnightFreeBoard(){
        Knight knight = new Knight(true);
        board.setSpot(knight, 4,6);

        //Positives
        assertTrue(knight.canMove(board, board.getSpot(4,6), board.getSpot(3,8)));
        assertTrue(knight.canMove(board, board.getSpot(4,6), board.getSpot(5,8)));

        //Negatives
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(6,7)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(6,5)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(3,4)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(5,4)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveWhiteKnightFreeBoard(){
        Knight knight = new Knight(false);
        board.setSpot(knight, 4,6);

        //Positives
        assertTrue(knight.canMove(board, board.getSpot(4,6), board.getSpot(3,4)));
        assertTrue(knight.canMove(board, board.getSpot(4,6), board.getSpot(5,4)));

        //Negatives
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(6,7)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(6,5)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(3,8)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(5,8)));
        assertFalse(knight.canMove(board, board.getSpot(4,6), board.getSpot(2,7)));
    }

    @Test
    void moveBlackKnightFilledBoard(){

        Knight knight = new Knight(true);
        board.initialize();
        board.setSpot(knight, 4,3);
        board.setSpot(new GoldGeneral(true), 5, 5);

        //Positives
        assertTrue(knight.canMove(board, board.getSpot(4,3), board.getSpot(3,5)));

        //Negatives
        assertFalse(knight.canMove(board, board.getSpot(4,3), board.getSpot(5,5)));
    }

    @Test
    void moveWhiteKnightFilledBoard(){
        Knight knight = new Knight(false);
        board.initialize();
        board.setSpot(knight, 4,5);
        board.setSpot(new GoldGeneral(false), 3, 3);

        //Positives
        assertTrue(knight.canMove(board, board.getSpot(4,5), board.getSpot(5,3)));

        //Negatives
        assertFalse(knight.canMove(board, board.getSpot(4,5), board.getSpot(3,3)));
    }
}