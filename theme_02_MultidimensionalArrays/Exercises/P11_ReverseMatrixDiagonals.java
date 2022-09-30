package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11_ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int startRow = matrix.length - 1;
        int startCol = matrix[startRow].length - 1;

        while (startRow >= 0) {
            int nextRow = startRow;
            int nextCol = startCol;

            while (isInBounds(nextRow, nextCol, matrix)) {
                int currentElement = matrix[nextRow][nextCol];
                System.out.print(currentElement + " ");
                nextRow--;
                nextCol++;
            }
            System.out.println();

            startCol--;

            if (startCol < 0) {
                startRow--;
                startCol = 0;
            }
        }

    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
