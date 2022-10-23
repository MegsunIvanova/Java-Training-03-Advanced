package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_Bee_vEP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];
        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < territory.length; row++) {
            String singleRow = scanner.nextLine();
            territory[row] = singleRow.toCharArray();
            for (int col = 0; col < territory[row].length; col++) {
                if (territory[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        int flowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            territory[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                flowers++;
            } else if (territory[beeRow][beeCol] == 'O') {
                continue;
            }

            territory[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowers);
        }

        System.out.println(Arrays.stream(territory)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
