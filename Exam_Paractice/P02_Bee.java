package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_Bee {
    public static char[][] territoryMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        territoryMatrix = new char[size][size];
        int rowBee = -1;
        int colBee = -1;

        for (int row = 0; row < territoryMatrix.length; row++) {
            String dataForRow = scanner.nextLine();
            territoryMatrix[row] = dataForRow.toCharArray();
            if (dataForRow.contains("B")) {
                rowBee = row;
                colBee = dataForRow.indexOf('B');
            }
        }

        int pollinatedFlowers = 0;
        boolean gotLost = false;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            territoryMatrix[rowBee][colBee] = '.';
            int[] nextPosition = getNextPosition(rowBee, colBee, command);
            rowBee = nextPosition[0];
            colBee = nextPosition[1];

            if (!isInBounds(rowBee, colBee)) {
                gotLost = true;
                break;
            }

            char symbol = territoryMatrix[rowBee][colBee];
            if (symbol == 'f') {
                pollinatedFlowers++;
            }

            if (symbol == 'O') {
                continue;
            }

            territoryMatrix[rowBee][colBee] = 'B';

            command = scanner.nextLine();
        }

        if (gotLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        }

        System.out.println(Arrays.stream(territoryMatrix)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static boolean isInBounds(int rowBee, int colBee) {
        return rowBee >= 0 && rowBee < territoryMatrix.length
                && colBee >= 0 && colBee < territoryMatrix[rowBee].length;
    }

    private static int[] getNextPosition(int rowBee, int colBee, String command) {
        switch (command) {
            case "up":
                return new int[]{--rowBee, colBee};
            case "down":
                return new int[]{++rowBee, colBee};
            case "left":
                return new int[]{rowBee, --colBee};
            case "right":
                return new int[]{rowBee, ++colBee};
            default:
                return null;
        }
    }
}
