package Exam_Paractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_Snake {

    public static List<Integer> burrowsCoordinates = new ArrayList<>();
    public static char[][] territoryMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        territoryMatrix = new char[size][size];
        int rowSnake = -1;
        int colSnake = -1;


        for (int row = 0; row < territoryMatrix.length; row++) {
            String data = scanner.nextLine();
            territoryMatrix[row] = data.toCharArray();
            if (data.contains("S")) {
                rowSnake = row;
                colSnake = data.indexOf('S');
            }
            if (data.contains("B")) {
                burrowsCoordinates.add(row);
                burrowsCoordinates.add(data.indexOf('B'));
            }
        }

        int foodEaten = 0;
        boolean outOfTerritory = false;

        while (foodEaten < 10) {
            String command = scanner.nextLine();
            territoryMatrix[rowSnake][colSnake] = '.';
            int[] nextPosition = getNextPosition(rowSnake, colSnake, command);
            rowSnake = nextPosition[0];
            colSnake = nextPosition[1];
            if (!isInBounds(rowSnake, colSnake)) {
                outOfTerritory = true;
                break;
            }
            char symbol = territoryMatrix[rowSnake][colSnake];
            if (symbol == '*') {
                foodEaten++;
            }
            if (symbol == 'B') {
                territoryMatrix[rowSnake][colSnake] = '.';
                int[] otherBurrow = getOtherBurrow(rowSnake, colSnake);
                rowSnake = otherBurrow[0];
                colSnake = otherBurrow[1];

            }
            territoryMatrix[rowSnake][colSnake] = 'S';

        }

        if (outOfTerritory) {
            System.out.println("Game over!");
        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + foodEaten);
        System.out.println(Arrays.stream(territoryMatrix).map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }


    private static int[] getOtherBurrow(int rowSnake, int colSnake) {
        if (rowSnake == burrowsCoordinates.get(0) && colSnake == burrowsCoordinates.get(1)) {
            return new int[]{burrowsCoordinates.get(2), burrowsCoordinates.get(3)};
        }

        if (rowSnake == burrowsCoordinates.get(2) && colSnake == burrowsCoordinates.get(3)) {
            return new int[]{burrowsCoordinates.get(0), burrowsCoordinates.get(1)};
        }

        return null;

    }

    private static boolean isInBounds(int rowSnake, int colSnake) {
        return rowSnake >= 0 && rowSnake < territoryMatrix.length
                && colSnake >= 0 && colSnake < territoryMatrix[rowSnake].length;
    }

    private static int[] getNextPosition(int rowSnake, int colSnake, String command) {
        switch (command) {
            case "up":
                return new int[]{--rowSnake, colSnake};
            case "down":
                return new int[]{++rowSnake, colSnake};
            case "left":
                return new int[]{rowSnake, --colSnake};
            case "right":
                return new int[]{rowSnake, ++colSnake};
            default:
                return null;
        }


    }
}
