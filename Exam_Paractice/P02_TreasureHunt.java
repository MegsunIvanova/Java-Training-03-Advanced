package Exam_Paractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] treasureMap = new char[rows][cols];
        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < rows; row++) {
            String rowData = scanner.nextLine().replaceAll("\\s+", "");
            treasureMap[row] = rowData.toCharArray();
            if (rowData.contains("Y")) {
                playerRow = row;
                playerCol = rowData.indexOf("Y");
            }
        }

        List<String> steps = new ArrayList<>();


        String step = scanner.nextLine();

        while (!step.equals("Finish")) {
            switch (step) {
                case "up":
                    if (isPossibleToMove(playerRow - 1, playerCol, treasureMap)) {
                        playerRow = playerRow - 1;
                        steps.add(step);
                    }
                    break;
                case "down":
                    if (isPossibleToMove(playerRow + 1, playerCol, treasureMap)) {
                        playerRow = playerRow + 1;
                        steps.add(step);
                    }
                    break;
                case "right":
                    if (isPossibleToMove(playerRow, playerCol + 1, treasureMap)) {
                        playerCol = playerCol + 1;
                        steps.add(step);
                    }
                    break;
                case "left":
                    if (isPossibleToMove(playerRow, playerCol - 1, treasureMap)) {
                        playerCol = playerCol - 1;
                        steps.add(step);
                    }
                    break;
            }
            step = scanner.nextLine();
        }

        char positionSymbol = treasureMap[playerRow][playerCol];
        if (positionSymbol == 'X') {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s\n", String.join(", ", steps));
        } else {
            System.out.println("The map is fake!");
        }


    }

    private static boolean isPossibleToMove(int row, int col, char[][] matrix) {
        return isInBounds(row, col, matrix) && isFreeOfTree(row, col, matrix);
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isFreeOfTree(int row, int col, char[][] matrix) {
        return matrix[row][col] != 'T';
    }
}
