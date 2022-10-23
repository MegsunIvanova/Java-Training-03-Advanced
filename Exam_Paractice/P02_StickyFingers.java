package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P02_StickyFingers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];

        String[] commands = scanner.nextLine().split(",");
        int dillingerRow = -1;
        int dillingerCol = -1;
        int pocket = 0;
        boolean isCaught = false;

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            field[row] = input.toCharArray();
            if (input.contains("D")) {
                dillingerRow = row;
                dillingerCol = input.indexOf('D');
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            int[] coordinates = getCoordinates(command, dillingerRow, dillingerCol);
            int row = coordinates[0];
            int col = coordinates[1];

            if (!isInBounds(row, col, field)) {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }
            //Dillinger moves
            field[dillingerRow][dillingerCol] = '+';

            char symbol = field[row][col];

            if (symbol == '$') {
                int stolen = row * col;
                pocket += stolen;
                System.out.println("You successfully stole " + stolen + "$.");
            } else if (symbol == 'P') {
                System.out.println("You got caught with " + pocket + "$, and you are going to jail.");
                isCaught = true;
                field[row][col] = '#';
                break;
            }
            dillingerRow = row;
            dillingerCol = col;
            field[row][col] = 'D';

        }

        if (!isCaught) {
            System.out.println("Your last theft has finished successfully with " + pocket + "$ in your pocket.");
        }

        for (int row = 0; row < field.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (char symbol : field[row]) {
                sb.append(symbol).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static int[] getCoordinates(String command, int dillingerRow, int dillingerCol) {
        switch (command) {
            case "left":
                return new int[]{dillingerRow, dillingerCol - 1};

            case "right":
                return new int[]{dillingerRow, dillingerCol + 1};

            case "up":
                return new int[]{dillingerRow - 1, dillingerCol};

            case "down":
                return new int[]{dillingerRow + 1, dillingerCol};
            default:
                return null;
        }


    }

    private static boolean isInBounds(int row, int col, char[][] field) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }
}
