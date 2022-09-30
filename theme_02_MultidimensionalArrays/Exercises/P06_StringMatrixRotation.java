package theme_02_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationInput = scanner.nextLine();
        List<String> wordsList = new ArrayList<>();
        int maxColumnLength = Integer.MIN_VALUE;
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            wordsList.add(input);
            int currentLength = input.length();
            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }

            input = scanner.nextLine();
        }

        int rows = wordsList.size();
        int cols = maxColumnLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String word = wordsList.get(row);
            int wordLength = word.length();
            for (int col = 0; col < cols; col++) {
                char symbol = ' ';
                if (col < wordLength) {
                    symbol = word.charAt(col);
                }
                matrix[row][col] = symbol;
            }
        }

        int angle = Integer.parseInt(rotationInput
                .split("[()]")[1]);

        int angeleOfRotations = (angle % 360);

        printMatrix(matrix, rows, cols, angeleOfRotations);

//        System.out.println(angeleOfRotations);

    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angeleOfRotations) {
        switch (angeleOfRotations) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }


    }
}
