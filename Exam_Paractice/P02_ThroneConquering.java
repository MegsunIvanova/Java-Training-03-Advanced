package Exam_Paractice;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ThroneConquering {

    static char[][] fieldOfSparta = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        fieldOfSparta = new char[rows][];
        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < rows; row++) {
            String data = scanner.nextLine();
            fieldOfSparta[row] = data.toCharArray();
            if (data.contains("P")) {
                //P  Paris, the player character
                parisRow = row;
                parisCol = data.indexOf('P');
            }
        }

        boolean isHelenSaved = false;
        boolean isParisDead = false;

        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String direction = input[0];
            int spawnsRow = Integer.parseInt(input[1]);
            int spawnsCol = Integer.parseInt(input[2]);

            //1) Spartan spawns on the given indices
            //S Spartan, enemy
            fieldOfSparta[spawnsRow][spawnsCol] = 'S';

            //2) Paris moves in a direction, which decreases his energy by 1.
            //o	It can be "up", "down", "left", "right".
            energy--;
            fieldOfSparta[parisRow][parisCol] = '-';
            int[] nextPosition = getNextRowAndCol(parisRow, parisCol, direction);
            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];
            char nextFieldSymbol = fieldOfSparta[nextRow][nextCol];
            parisRow = nextRow;
            parisCol = nextCol;
            fieldOfSparta[parisRow][parisCol] = 'P';

            if (nextFieldSymbol == 'S') {
                //Paris fights him, which decreases his energy by 2
                energy -= 2;
            }
            if (nextFieldSymbol == 'H') {
                //H  Helen
                //they both run away
                isHelenSaved = true;
                fieldOfSparta[parisRow][parisCol] = '-';
                break;
            }

            if (energy > 0) {
                fieldOfSparta[parisRow][parisCol] = 'P';
            } else {
                fieldOfSparta[parisRow][parisCol] = 'X';
                isParisDead = true;

            }
        }

        if (isParisDead) {
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
        }

        if (isHelenSaved) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
        }

        System.out.println(Arrays.stream(fieldOfSparta)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static int[] getNextRowAndCol(int currentRow, int currentCol, String direction) {
        int nextRow = currentRow;
        int nextCol = currentCol;

        switch (direction) {
            case "up":
                nextRow--;
                break;
            case "down":
                nextRow++;
                break;
            case "left":
                nextCol--;
                ;
                break;
            case "right":
                nextCol++;
                break;
        }

        if (!isInBounds(nextRow, nextCol)) {
            //o	If Paris tries to move outside of the field,
            // he doesn’t move but still has his energy decreased
            nextRow = currentRow;
            nextCol = currentCol;
        }

        return new int[]{nextRow, nextCol};
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < fieldOfSparta.length
                && col >= 0 && col <= fieldOfSparta[row].length;
    }
}
