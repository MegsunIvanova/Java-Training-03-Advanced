package Exam_Paractice;

import java.util.Scanner;

public class P02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int whitePawnRow = -1;
        int whitePawnCol = -1;
        int blackPawnRow = -1;
        int blackPawnCol = -1;

        char[][] chessboard = new char[8][8];
        for (int row = 0; row < chessboard.length; row++) {
            String input = scanner.nextLine();
            chessboard[row] = input.toCharArray();
            if (input.contains("w")) {
                whitePawnRow = row;
                whitePawnCol = input.indexOf('w');
            }
            if (input.contains("b")) {
                blackPawnRow = row;
                blackPawnCol = input.indexOf('b');
            }
        }

        boolean isGameContinue = true;
        boolean isWhiteTurn = true;

        while (isGameContinue) {
            if (isWhiteTurn) {
                if (whiteCapture(whitePawnRow, whitePawnCol, chessboard)) {
                    isGameContinue = false;
                } else {
                    chessboard[whitePawnRow][whitePawnCol] = '-';
                    whitePawnRow--;
                    chessboard[whitePawnRow][whitePawnCol] = 'w';

                    if (whitePawnRow == 0) {
                        String coordinates = getCoordinates(whitePawnRow, whitePawnCol);
                        System.out.printf("Game over! White pawn is promoted to a queen at %s.\n", coordinates);
                        isGameContinue = false;
                    }

                    isWhiteTurn = false;
                }

            } else {
                if (blackCapture(blackPawnRow, blackPawnCol, chessboard)) {
                    isGameContinue = false;
                } else {
                    chessboard[blackPawnRow][blackPawnCol] = '-';
                    blackPawnRow++;
                    chessboard[blackPawnRow][blackPawnCol] = 'b';
                    if (blackPawnRow == chessboard.length - 1) {
                        String coordinates = getCoordinates(blackPawnRow, blackPawnCol);
                        System.out.printf("Game over! Black pawn is promoted to a queen at %s.\n", coordinates);
                        isGameContinue = false;
                    }
                    isWhiteTurn = true;
                }
            }


        }


    }

    private static boolean whiteCapture(int currentRow, int currentCol, char[][] chessboard) {
        char leftDiagonal = '-';
        if (isInBounds(currentRow - 1, currentCol - 1)) {
            leftDiagonal = chessboard[currentRow - 1][currentCol - 1];
        }

        char rightDiagonal = '-';
        if (isInBounds(currentRow - 1, currentCol + 1)) {
            rightDiagonal = chessboard[currentRow - 1][currentCol + 1];
        }

        String coordinates = null;
        if (leftDiagonal == 'b') {
            coordinates = getCoordinates(currentRow - 1, currentCol - 1);
            chessboard[currentRow][currentCol] = '-';
            chessboard[currentRow - 1][currentCol - 1] = 'w';
        }
        if (rightDiagonal == 'b') {
            coordinates = getCoordinates(currentRow - 1, currentCol + 1);
            chessboard[currentRow][currentCol] = '-';
            chessboard[currentRow - 1][currentCol + 1] = 'w';
        }

        if (coordinates != null) {
            System.out.printf("Game over! White capture on %s.\n", coordinates);
            return true;
        }

        return false;
    }

    private static boolean blackCapture(int currentRow, int currentCol, char[][] chessboard) {
        char leftDiagonal = '-';
        if (isInBounds(currentRow + 1, currentCol - 1)) {
            leftDiagonal = chessboard[currentRow + 1][currentCol - 1];
        }
        char rightDiagonal = '-';
        if (isInBounds(currentRow + 1, currentCol + 1)) {
            rightDiagonal = chessboard[currentRow + 1][currentCol + 1];
        }

        String coordinates = null;
        if (leftDiagonal == 'w') {
            coordinates = getCoordinates(currentRow + 1, currentCol - 1);
            chessboard[currentRow][currentCol] = '-';
            chessboard[currentRow + 1][currentCol - 1] = 'b';
        }
        if (rightDiagonal == 'w') {
            coordinates = getCoordinates(currentRow + 1, currentCol + 1);
            chessboard[currentRow][currentCol] = '-';
            chessboard[currentRow + 1][currentCol + 1] = 'b';
        }

        if (coordinates != null) {
            System.out.printf("Game over! Black capture on %s.\n", coordinates);
            return true;
        }
        return false;
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private static String getCoordinates(int row, int col) {
        int rank = 8 - row;
        char chessCol = (char) (col + 'a');
        return "" + chessCol + rank;
    }
}
