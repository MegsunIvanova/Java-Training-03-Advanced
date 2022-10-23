package Exam_Paractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_CookingJourney {
    private static char[][] shopMatrix;
    private static List<Integer> pillars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        shopMatrix = new char[size][size];
        int rowPosition = -1;
        int colPosition = -1;

        for (int row = 0; row < shopMatrix.length; row++) {
            String rowData = scanner.nextLine();
            shopMatrix[row] = rowData.toCharArray();

            if (rowData.contains("S")) {
                rowPosition = row;
                colPosition = rowData.indexOf('S');
            }

            if (rowData.contains("P")) {
                pillars.add(row);
                pillars.add(rowData.indexOf('P'));
            }
        }

        int collectedMoney = 0;
        boolean isOutside = false;

        while (collectedMoney < 50) {
            String command = scanner.nextLine();
            shopMatrix[rowPosition][colPosition] = '-';
            int nextRow = getNextPoint(rowPosition, colPosition, command)[0];
            int nextCol = getNextPoint(rowPosition, colPosition, command)[1];

            if (!isInBounds(nextRow, nextCol)) {
                isOutside = true;
                break;
            }
            rowPosition = nextRow;
            colPosition = nextCol;
            char symbol = shopMatrix[rowPosition][colPosition];

            if (symbol == 'P') {
                shopMatrix[rowPosition][colPosition] = '-';
                int[] newPosition = getOtherPillarPoint(rowPosition, colPosition);
                rowPosition = newPosition[0];
                colPosition = newPosition[1];
            } else if (Character.isDigit(symbol)) {
                collectedMoney += Character.getNumericValue(symbol);
            }
            shopMatrix[rowPosition][colPosition] = 'S';

        }

        if (isOutside) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + collectedMoney);

        System.out.println(Arrays.stream(shopMatrix).map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static int[] getOtherPillarPoint(int currentRow, int currentCol) {
        if (currentRow == pillars.get(0) && currentCol == pillars.get(1)) {
            return new int[]{pillars.get(2), pillars.get(3)};
        } else {
            return new int[]{pillars.get(0), pillars.get(1)};
        }
    }

    private static boolean isInBounds(int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < shopMatrix.length && nextCol >= 0 && nextCol < shopMatrix[nextRow].length;
    }

    private static int[] getNextPoint(int rowPosition, int colPosition, String command) {
        switch (command) {
            case "up":
                return new int[]{--rowPosition, colPosition};
            case "down":
                return new int[]{++rowPosition, colPosition};
            case "left":
                return new int[]{rowPosition, --colPosition};
            case "right":
                return new int[]{rowPosition, ++colPosition};
            default:
                return new int[]{rowPosition, colPosition};
        }
    }
}



