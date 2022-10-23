package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ReVolt {
    public static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        matrix = new char[size][size];
        int rowPlayer = -1;
        int colPlayer = -1;

        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            matrix[row] = data.toCharArray();
            if (data.contains("f")) {
                rowPlayer = row;
                colPlayer = data.indexOf('f');
            }
        }

        boolean reachedFinish = false;

        while (numberOfCommands-- > 0) {
            String command = scanner.nextLine();
            int nextRow = getNexRow(rowPlayer, command);
            int nextCol = getNexCol(colPlayer, command);

            char symbol = matrix[nextRow][nextCol];

            if (symbol == 'T') {
                continue;
            }

            if (symbol == 'B') {
                nextRow = getNexRow(nextRow, command);
                nextCol = getNexCol(nextCol, command);
                symbol = matrix[nextRow][nextCol];
            }

            matrix[rowPlayer][colPlayer] = '-';
            rowPlayer = nextRow;
            colPlayer = nextCol;
            matrix[rowPlayer][colPlayer] = 'f';

            if (symbol == 'F') {
                reachedFinish = true;
                break;
            }
        }

        if (reachedFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        System.out.println(Arrays.stream(matrix)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static int getNexRow(int rowPlayer, String command) {
        int next = rowPlayer;
        if ("up".equals(command)) {
            next--;
        } else if ("down".equals(command)) {
            next++;
        }
        if (next < 0) {
            next = matrix.length - 1;
        }
        if (next > matrix.length - 1) {
            next = 0;
        }
        return next;
    }

    private static int getNexCol(int colPlayer, String command) {
        int next = colPlayer;
        if ("left".equals(command)) {
            next--;
        } else if ("right".equals(command)) {
            next++;
        }
        if (next < 0) {
            next = matrix.length - 1;
        }
        if (next > matrix.length - 1) {
            next = 0;
        }
        return next;
    }
}
