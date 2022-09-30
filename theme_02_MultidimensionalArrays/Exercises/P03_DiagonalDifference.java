package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int primaryDiagonalSum = 0;

        for (int index = 0; index < matrix.length; index++) {
            primaryDiagonalSum += matrix[index][index];
        }

        int secondDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            int col = size - 1 - row;
            secondDiagonalSum += matrix[row][col];
        }

        int diff = Math.abs(primaryDiagonalSum - secondDiagonalSum);
        System.out.println(diff);

    }


}
