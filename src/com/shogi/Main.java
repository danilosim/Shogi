package com.shogi;

public class Main {

    public static void main(String[] args) {

//        Board board = new Board();
//        board.printBoard();
//        System.out.println(board.getSpot(0,0).getPiece().canMove(board, board.getSpot(0, 0), board.getSpot(1,1)));

        Game game = new Game();
        Player blackPlayer = new Player(true);
        Player whitePlayer = new Player(false);
        game.initialize(blackPlayer, whitePlayer);
        game.getBoard().printBoard();

//        System.out.println(game.getBoard().getSpot(0,2).getPiece().toString());
        game.playerMove(blackPlayer, 0, 2, 0, 3);
        game.getBoard().printBoard();
    }
}
