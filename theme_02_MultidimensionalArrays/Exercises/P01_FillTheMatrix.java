package theme_02_MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            int value = 1;
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = value;
                    value++;
                }
            }

        } else if (pattern.equals("B")) {
            int value = 1;
            for (int col = 0; col < n; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = value;
                        value++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = value;
                        value++;
                    }
                }
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
