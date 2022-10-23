package Exam_Paractice;

import java.util.Scanner;

public class P02_Bomb {
    public static char[][] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        field = new char[size][size];
        String[] commands = scanner.nextLine().split(",");
        int rowPosition = -1;
        int colPosition = -1;
        int totalBombs = 0;

        for (int row = 0; row < field.length; row++) {
            String dataRow = scanner.nextLine().replaceAll("\\s+", "");
            field[row] = dataRow.toCharArray();

            if (dataRow.contains("s")) {
                rowPosition = row;
                colPosition = dataRow.indexOf('s');
            }

            if (dataRow.contains("B")) {
                int bombsInRow = dataRow.length() - dataRow.replace("B", "").length();
                totalBombs += bombsInRow;
            }
        }

        int foundedBobs = 0;
        boolean isEndReached = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] nextPosition = getNextPosition(rowPosition, colPosition, command);
            //  field[rowPosition][colPosition] = '+';
            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];
            rowPosition = nextRow;
            colPosition = nextCol;
            char symbol = field[nextRow][nextCol];

            if (symbol == 'B') {
                field[rowPosition][colPosition] = '+';
                foundedBobs++;
                System.out.println("You found a bomb!");
            }

            if (symbol == 'e') {
                isEndReached = true;
                break;
            }

        }


        if (totalBombs - foundedBobs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEndReached) {
            System.out.printf("END! %d bombs left on the field\n", totalBombs - foundedBobs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", totalBombs - foundedBobs, rowPosition, colPosition);
        }


    }

    private static int[] getNextPosition(int rowPosition, int colPosition, String command) {
        int[] nextPosition = new int[]{rowPosition, colPosition};
        switch (command) {
            case "left":
                nextPosition[1]--;
                break;
            case "right":
                nextPosition[1]++;
                break;
            case "up":
                nextPosition[0]--;
                break;
            case "down":
                nextPosition[0]++;
                break;
        }

        if (isInBounds(nextPosition)) {
            return nextPosition;
        } else {
            return new int[]{rowPosition, colPosition};
        }


    }

    private static boolean isInBounds(int[] nextPosition) {
        return nextPosition[0] >= 0 && nextPosition[0] < field.length
                && nextPosition[1] >= 0 && nextPosition[1] < field[nextPosition[0]].length;
    }
}
