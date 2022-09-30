package theme_02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ParkingSystem {

    private static boolean[][] parkingMatrix;
    private static int distance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        parkingMatrix = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            parkingMatrix[row][0] = true;
        }

        String input = scanner.nextLine();

        while (!input.equals("stop")) {

            int[] coordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int entryRow = coordinates[0];
            int spotRow = coordinates[1];
            int spotCol = coordinates[2];
            distance = 0;

            if (!parkingMatrix[spotRow][spotCol]) {  //if initial spot is free
                parkOnTheSpot(entryRow, spotRow, spotCol);
            } else { //if initial spot is full

                int spotColLeft = spotCol;
                int spotColRight = spotCol;

                while (spotColLeft > 0 || spotColRight < parkingMatrix[spotRow].length) {

                    if (spotColLeft > 0 && !parkingMatrix[spotRow][spotColLeft]) {
                        parkOnTheSpot(entryRow, spotRow, spotColLeft);
                        break;
                    }

                    if (spotColRight < parkingMatrix[spotRow].length && !parkingMatrix[spotRow][spotColRight]) {
                        parkOnTheSpot(entryRow, spotRow, spotColRight);
                        break;
                    }

                    spotColLeft--;
                    spotColRight++;

                }
            }

            if (distance > 0) {
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full\n", spotRow);
            }

            input = scanner.nextLine();

        }

    }

    private static int getDistance(int entryRow, int spotRow, int spotCol) {
        return Math.abs(entryRow - spotRow) + 1 + spotCol;

    }

    private static void parkOnTheSpot(int entryRow, int spotRow, int spotCol) {
        parkingMatrix[spotRow][spotCol] = true;
        distance = getDistance(entryRow, spotRow, spotCol);
    }
}
