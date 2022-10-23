package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_RallyRacing {

    private static int carRow = 0;
    private static int carCol = 0;
    private static List<Integer> tunnels = new ArrayList<>();
    private static int distance = 0;
    private static boolean hadFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String rowData = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = rowData.toCharArray();
            if (rowData.contains("T")) {
                tunnels.add(r);
                tunnels.add(rowData.indexOf("T"));
            }
        }

        matrix[carRow][carCol] = 'C';
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {

            if (direction.equals("left")) {
                moveCar(matrix, 0, -1);
            } else if (direction.equals("right")) {
                moveCar(matrix, 0, 1);
            } else if (direction.equals("up")) {
                moveCar(matrix, -1, 0);
            } else if (direction.equals("down")) {
                moveCar(matrix, 1, 0);
            }

//            System.out.println("======");
//            printMatrix(matrix);

            if (hadFinished) {
                break;
            }
            direction = scanner.nextLine();
        }

        if (hadFinished) {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }

        System.out.printf("Distance covered %d km.\n", distance);

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        System.out.println(Arrays.stream(matrix)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }


    private static void moveCar(char[][] matrix, int rowMutator, int colMutator) {
        matrix[carRow][carCol] = '.';
        carRow = carRow + rowMutator;
        carCol = carCol + colMutator;
        distance += 10;

        if (matrix[carRow][carCol] == 'T') {
            distance += 20;
            matrix[carRow][carCol] = '.';
            if (carRow == tunnels.get(0) && carCol == tunnels.get(1)) {
                carRow = tunnels.get(2);
                carCol = tunnels.get(3);
            } else if (carRow == tunnels.get(2) && carCol == tunnels.get(3)) {
                carRow = tunnels.get(0);
                carCol = tunnels.get(1);
            }

        } else if (matrix[carRow][carCol] == 'F') {
            hadFinished = true;
        }

        matrix[carRow][carCol] = 'C';
    }
}
