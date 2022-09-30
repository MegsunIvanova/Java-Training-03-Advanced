package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10_RadioactiveMutantVampireBunnies {

    private static boolean[][] lairMatrix;
    private static int rows;
    private static int cols;
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        rows = dimensions[0];
        cols = dimensions[1];
        lairMatrix = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            String rowInput = scanner.nextLine();
            for (int col = 0; col < rowInput.length(); col++) {
                char symbol = rowInput.charAt(col);
                if (symbol == 'B') {
                    lairMatrix[row][col] = true;
                }
                if (symbol == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean isPlayerWon = false;

        String commands = scanner.nextLine();
        for (char commandSymbol : commands.toCharArray()) {
            //player move
            switch (commandSymbol) {
                case 'L': // Left
                    if (playerCol > 0) {
                        playerCol--;
                    } else {
                        isPlayerWon = true;
                    }
                    break;
                case 'R': // Right
                    if (playerCol < lairMatrix[playerRow].length - 1) {
                        playerCol++;
                    } else {
                        isPlayerWon = true;
                    }
                    break;
                case 'U': // Up
                    if (playerRow > 0) {
                        playerRow--;
                    } else {
                        isPlayerWon = true;
                    }
                    break;
                case 'D': // Down
                    if (playerRow < lairMatrix.length - 1) {
                        playerRow++;
                    } else {
                        isPlayerWon = true;
                    }
                    break;
            }
            //the bunnies spread to the up, down, left, and right
            spreadBunnies();

            //player won or is dead
            if (isPlayerWon || lairMatrix[playerRow][playerCol]) {
                break;
            }


        }

        printLairMatrix();
        String output = isPlayerWon ? String.format("won: %s %s", playerRow, playerCol)
                : String.format("dead: %s %s", playerRow, playerCol);
        System.out.println(output);

    }

    private static void printLairMatrix() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(lairMatrix[row][col] ? "B" : ".");
            }
            System.out.println();
        }
    }

    private static void spreadBunnies() {
        boolean[][] newLairMatrix = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (shallWePutABunny(row, col)) {
                    newLairMatrix[row][col] = true;
                }
            }
        }
        lairMatrix = newLairMatrix;

    }

    private static boolean shallWePutABunny(int row, int col) {
        //check current cell
        if (lairMatrix[row][col]) {
            return true;
        }

        // check left cell
        if (col > 0 && lairMatrix[row][col - 1]) {
            return true;
        }

        // check right cell
        if (col < lairMatrix[row].length - 1 && lairMatrix[row][col + 1]) {
            return true;
        }

        // check up cell
        if (row > 0 && lairMatrix[row - 1][col]) {
            return true;
        }

        // check down cell
        if (row < lairMatrix.length - 1 && lairMatrix[row + 1][col]) {
            return true;
        }

        return false;
    }


}
