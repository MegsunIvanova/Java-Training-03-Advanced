package Exam_Paractice;

import java.util.Scanner;

public class P02_ReVolt_vEP {
    public static int playerRow;
    public static int playerCol;
    public static boolean hasWon = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();

            if (matrixRow.contains("f")) {
                playerRow = row;
                playerCol = matrixRow.indexOf("f");
            }
        }

        while (commandsCount-- > 0 && !hasWon) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                movePlayer(matrix, -1, 0);
            } else if (command.equals("down")) {
                movePlayer(matrix, 1, 0);
            } else if (command.equals("left")) {
                movePlayer(matrix, 0, -1);
            } else if (command.equals("right")) {
                movePlayer(matrix, 0, 1);
            }
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        print(matrix);

    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nexCol = playerCol + colMutator;

        if (isOutOfBounds(matrix, nextRow, nexCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nexCol = nexCol < 0 ? matrix[nextRow].length - 1 : 0;
            }
        }

        if (matrix[nextRow][nexCol] == 'T') {
            return;
        } else if (matrix[nextRow][nexCol] == 'B') {
            matrix[playerRow][playerCol] = '-';
            playerRow = nextRow;
            playerCol = nexCol;
            movePlayer(matrix, rowMutator, colMutator);
            return;
        } else if (matrix[nextRow][nexCol] == 'F') {
            hasWon = true;
        }
        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '-';
        }
        matrix[nextRow][nexCol] = 'f';
        playerRow = nextRow;
        playerCol = nexCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
