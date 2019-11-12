package com.shogi;

import com.shogi.pieces.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        Player blackPlayer = new Player(true);
        Player whitePlayer = new Player(false);

        game.initialize(blackPlayer, whitePlayer);

        while (true) {
            boolean validMove = false;

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

            String[] fromArray;
            String[] toArray;
            do {
                System.out.println("From (x y):");
                String from = scanner.nextLine();
                System.out.println("To (x y):");
                String to = scanner.nextLine();
                fromArray = from.split("\\s+");
                toArray = to.split("\\s+");
                if(fromArray.length == 2 && toArray.length == 2){
                    validMove = game.playerMove(current, Integer.parseInt(fromArray[0]), Integer.parseInt(fromArray[1]), Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
                }
            } while (!validMove);

            /* Forced Promotion */
            Piece piece = game.getBoard().getSpot(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1])).getPiece();
            if (current.isBlack() && Integer.parseInt(toArray[1]) == 8 && (piece.getClass() == Knight.class || piece.getClass() == Pawn.class || piece.getClass() == Lance.class)){
                game.promote(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
            }

            if (current.isBlack() && Integer.parseInt(toArray[1]) == 7 && piece.getClass() == Knight.class){
                game.promote(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
            }

            if (!current.isBlack() && Integer.parseInt(toArray[1]) == 0 && (piece.getClass() == Knight.class || piece.getClass() == Pawn.class || piece.getClass() == Lance.class)){
                game.promote(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
            }

            if (!current.isBlack() && Integer.parseInt(toArray[1]) == 1 && piece.getClass() == Knight.class){
                game.promote(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
            }

            /* Promotion */

            if ((current.isBlack() && (Integer.parseInt(fromArray[1]) >= 6 || Integer.parseInt(toArray[1]) >= 6)) || (!current.isBlack() && (Integer.parseInt(fromArray[1]) <= 2 || Integer.parseInt(toArray[1]) <= 2))){
                if (!piece.isPromoted){
                    if (piece.getClass() != King.class && piece.getClass() != GoldGeneral.class){
                        String response;
                        do{
                            System.out.println("Promote piece? (y/n)");
                            response = scanner.nextLine().trim();
                            if (response.toLowerCase().equals("y")){
                                game.promote(Integer.parseInt(toArray[0]), Integer.parseInt(toArray[1]));
                            }
                        } while (!response.toLowerCase().equals("y") && !response.toLowerCase().equals("n"));
                    }
                }
            }
        }
    }
}
