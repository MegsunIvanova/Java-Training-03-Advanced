package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandArr = input.split(" ");
            if (isValidCommand(commandArr, matrix)) {
                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);
                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];
                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;
                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    private static boolean isValidCommand(String[] commandArr, String[][] matrix) {
        if (commandArr.length != 5) {
            return false;
        }

        if (!commandArr[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandArr[1]);
        int col1 = Integer.parseInt(commandArr[2]);
        int row2 = Integer.parseInt(commandArr[3]);
        int col2 = Integer.parseInt(commandArr[4]);

        return row1 >= 0 && row2 >= 0 && col1 >= 0 && col2 >= 0
                && row1 < matrix.length && row2 < matrix.length
                && col1 < matrix[row1].length
                && col2 < matrix[row2].length;

    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(String.join(" ", matrix[r]));
        }
    }
}
