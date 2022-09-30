package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            char outsideLetter = (char) (row + 'a');
            for (int col = 0; col < cols; col++) {
                char insideLetter = (char) (outsideLetter + col);
                String element = "" + outsideLetter + insideLetter + outsideLetter;
                matrix[row][col] = element;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
