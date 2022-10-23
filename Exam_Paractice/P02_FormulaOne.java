package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_FormulaOne {
    private static char[][] matrix = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        matrix = new char[size][size];
        int rowPlayer = -1;
        int colPlayer = -1;

        for (int row = 0; row < matrix.length; row++) {
            String rowData = scanner.nextLine();
            matrix[row] = rowData.toCharArray();
            //'P' -> player
            if (rowData.contains("P")) {
                rowPlayer = row;
                colPlayer = rowData.indexOf('P');
            }
        }

        //'F' -> finish
        //'B' -> bonus
        //'T' -> trap

        boolean isPlayerWon = false;
        String command = "";
        boolean isBonusStep = false;

        while (count > 0 || isBonusStep) {
            if (!isBonusStep) {
                command = scanner.nextLine();
                count--;
            } else {
                isBonusStep = false;
            }
            int nextRow = getNextRow(rowPlayer, command);
            int nextCol = getNextCol(colPlayer, command);
            char positionSymbol = matrix[nextRow][nextCol];

            if (positionSymbol == 'F') {
                isPlayerWon = true;
                matrix[rowPlayer][colPlayer] = '.';
                rowPlayer = nextRow;
                colPlayer = nextCol;
                matrix[rowPlayer][colPlayer] = 'P';
                break;
            }

            if (positionSymbol == '.') {
                if (matrix[rowPlayer][colPlayer] == 'P') {
                    matrix[rowPlayer][colPlayer] = '.';
                }
                rowPlayer = nextRow;
                colPlayer = nextCol;
                matrix[rowPlayer][colPlayer] = 'P';
            }

            if (positionSymbol == 'B') {
                matrix[rowPlayer][colPlayer] = '.';
                rowPlayer = nextRow;
                colPlayer = nextCol;
                isBonusStep = true;
            }
        }

        if (isPlayerWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        System.out.println(Arrays.stream(matrix)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static int getNextRow(int rowPlayer, String command) {
        int nextRow = rowPlayer;
        if (command.equals("up")) {
            nextRow--;
        } else if (command.equals("down")) {
            nextRow++;
        }
        if (nextRow < 0) {
            nextRow = matrix.length - 1;
        } else if (nextRow >= matrix.length) {
            nextRow = 0;
        }

        return nextRow;

    }

    private static int getNextCol(int colPlayer, String command) {
        int nextCol = colPlayer;
        if (command.equals("left")) {
            nextCol--;
        } else if (command.equals("right")) {
            nextCol++;
        }

        if (nextCol < 0) {
            nextCol = matrix.length - 1;
        } else if (nextCol >= matrix.length) {
            nextCol = 0;
        }

        return nextCol;

    }
}
