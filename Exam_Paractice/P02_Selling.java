package Exam_Paractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_Selling {
    public static char[][] bakeryMatrix;
    public static List<Integer> pillarsCoordinates = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        bakeryMatrix = new char[size][size];
        int rowPosition = -1;
        int colPosition = -1;

        for (int row = 0; row < bakeryMatrix.length; row++) {
            String data = scanner.nextLine();
            bakeryMatrix[row] = data.toCharArray();

            if (data.contains("S")) {
                rowPosition = row;
                colPosition = data.indexOf('S');
            }

            if (data.contains("O")) {
                pillarsCoordinates.add(row);
                pillarsCoordinates.add(data.indexOf('O'));
            }
        }

        int money = 0;
        boolean outOfTheBakery = false;
        while (money < 50 && !outOfTheBakery) {
            String command = scanner.nextLine();
            bakeryMatrix[rowPosition][colPosition] = '-';
            int[] nextPosition = getNextPosition(rowPosition, colPosition, command);
            rowPosition = nextPosition[0];
            colPosition = nextPosition[1];
            if (!isInBounds(rowPosition, colPosition)) {
                outOfTheBakery = true;
                break;
            }
            char symbol = bakeryMatrix[rowPosition][colPosition];
            if (Character.isDigit(symbol)) {
                money += Character.getNumericValue(symbol);
            }
            if (symbol == 'O') {
                bakeryMatrix[rowPosition][colPosition] = '-';
                int[] otherPillarPosition = getOtherPillarPosition(rowPosition, colPosition);
                rowPosition = otherPillarPosition[0];
                colPosition = otherPillarPosition[1];
            }

            bakeryMatrix[rowPosition][colPosition] = 'S';
        }

        if (outOfTheBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);

        System.out.println(Arrays.stream(bakeryMatrix)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static int[] getOtherPillarPosition(int rowPosition, int colPosition) {
        if (rowPosition == pillarsCoordinates.get(0) && colPosition == pillarsCoordinates.get(1)) {
            return new int[]{pillarsCoordinates.get(2), pillarsCoordinates.get(3)};
        }

        if (rowPosition == pillarsCoordinates.get(2) && colPosition == pillarsCoordinates.get(3)) {
            return new int[]{pillarsCoordinates.get(0), pillarsCoordinates.get(1)};
        }

        return new int[]{rowPosition, colPosition};
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < bakeryMatrix.length && col >= 0 && col < bakeryMatrix[row].length;
    }

    private static int[] getNextPosition(int rowPosition, int colPosition, String command) {
        switch (command) {
            case "up":
                return new int[]{--rowPosition, colPosition};
            case "down":
                return new int[]{++rowPosition, colPosition};
            case "left":
                return new int[]{rowPosition, --colPosition};
            case "right":
                return new int[]{rowPosition, ++colPosition};
        }
        return new int[]{rowPosition, colPosition};
    }
}
