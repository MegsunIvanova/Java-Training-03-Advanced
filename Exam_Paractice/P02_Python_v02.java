package Exam_Paractice;

import java.util.Scanner;

public class P02_Python_v02 {
    private static int food = 0;
    private static int pRow = -1;
    private static int pCol = -1;
    private static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();

            if (line.contains("s")) {
                //found the snake
                pRow = r;
                pCol = line.indexOf("s");
            }

            for (char c : matrix[r]) {
                if (c == 'f') {
                    food++;
                }
            }
        }

        for (String command : commands) {
            if (command.equals("up")) {
                movePython(matrix, -1, 0);
            } else if (command.equals("down")) {
                movePython(matrix, 1, 0);
            } else if (command.equals("left")) {
                movePython(matrix, 0, -1);
            } else if (command.equals("right")) {
                movePython(matrix, 0, 1);
            }

            if (length == -1 || food == 0) {
                break;
            }

        }

        if (food == 0) {
            System.out.printf("You win! Final python length is %d\n", length);
        } else if (food > 0 && length != -1) {
            System.out.printf("You lose! There is still %d food to be eaten.\n", food);
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }

    }

    private static void movePython(char[][] matrix, int rowMutator, int colMutator) {
        int newRow = pRow + rowMutator;
        int newCol = pCol + colMutator;

        if (isOutOfBpunds(matrix, newRow, newCol)) {
            int[] newIndices = flipSnakeSide(matrix.length, newRow, newCol);
            newRow = newIndices[0];
            newCol = newIndices[1];
        }

        if (matrix[newRow][newCol] == 'e') {
            length = -1;
        } else if (matrix[newRow][newCol] == 'f') {
            length++;
            food--;
            // matrix [newRow][newCol] = '*';
        }

        pRow = newRow;
        pCol = newCol;

    }

    private static int[] flipSnakeSide(int length, int r, int c) {
        int[] result = new int[2];

        if (r < 0) {
            result[0] = length - 1;
            result[1] = c;
        } else if (r >= length) {
            result[1] = c;
        } else if (c < 0) {
            result[0] = r;
            result[1] = length - 1;
        } else if (c >= length) {
            result[0] = r;
        }

        return result;
    }

    private static boolean isOutOfBpunds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

}
