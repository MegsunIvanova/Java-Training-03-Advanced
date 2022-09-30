package theme_02_MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 2;
        int cols = 3;
        int[][] matrix = new int[rows][cols];

//        matrix[0][0] = 5;
//        matrix[1][2] = 15;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 12;
            }
        }
    }
}
