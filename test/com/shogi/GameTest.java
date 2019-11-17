package com.shogi;

import com.shogi.pieces.Bishop;
import com.shogi.pieces.GoldGeneral;
import com.shogi.pieces.King;
import com.shogi.pieces.Knight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void dropPreventingCheckmate() {
        Game game = new Game();
        Board board = new Board();
        Player blackPlayer = new Player(true);
        Player whitePlayer = new Player(false);
        Player[] playerArray = {blackPlayer, whitePlayer};

        King whiteKing = new King(false);
        King blackKing = new King(true);
        Knight blackKnight = new Knight(true);
        Bishop firstBlackBishop = new Bishop(true);
        Bishop secondBlackBishop = new Bishop(true);
        GoldGeneral whiteGoldGeneral = new GoldGeneral(false);
        whiteGoldGeneral.setCaptured(true);

        board.getSpot(0, 8).setPiece(whiteKing);
        board.getSpot(1, 5).setPiece(blackKnight);
        board.getSpot(2, 6).setPiece(firstBlackBishop);
        board.getSpot(3, 6).setPiece(secondBlackBishop);
        board.getSpot(4, 0).setPiece(blackKing);
        List<Piece> capturedPieces = new ArrayList<>();
        capturedPieces.add(whiteGoldGeneral);
        whitePlayer.setCapturedPieces(capturedPieces);
        game.setPlayers(playerArray);
        game.setCurrentTurn(blackPlayer);
        game.setBoard(board);
        assertFalse(game.isCheckmate(true));
    }
}