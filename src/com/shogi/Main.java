package com.shogi;

import com.shogi.pieces.Bishop;
import com.shogi.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        Player blackPlayer = new Player(true);
        Player whitePlayer = new Player(false);

        game.initialize(blackPlayer, whitePlayer);

        while (true) {
            boolean validMove;

            Player current = game.getCurrentTurn();
            if (current.isBlack()){
                System.out.println("----------Black's turn----------");
            }else {
                System.out.println("----------White's turn----------");
            }

            game.getBoard().printBoard();


            int captured = current.getCapturedPieces().size();
            if (captured != 0) {
                System.out.println("Captured Pieces:");
                System.out.print("9: ");
                for (int i = captured; i > 0; i--) {
                    System.out.print(captured - i + "  ");
                }
                System.out.print("\n   ");
                for (Piece piece : current.getCapturedPieces()) {
                    System.out.print(piece.getId() + " ");
                }
                System.out.print("\n");
            }

            do {
                System.out.println("From (x y):");
                String from = scanner.nextLine();
                System.out.println("To (x y):");
                String to = scanner.nextLine();
                String[] fromArray = from.split("\\s+");
                String[] toArray = to.split("\\s+");
                validMove = game.playerMove(current, Integer.parseInt(fromArray[0]), Integer.parseInt(fromArray[1]), Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
            } while (!validMove);
        }
    }
}
