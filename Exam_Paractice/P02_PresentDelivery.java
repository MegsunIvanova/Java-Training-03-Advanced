package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_PresentDelivery {
    private static char[][] neighborhood;
    private static int countPresents;
    private static int niceKidWithPresent = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        countPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        neighborhood = new char[size][size];
        int rowSanta = 1;
        int colSanta = 1;
        int niceKidsCounter = 0;

        for (int row = 0; row < neighborhood.length; row++) {
            String data = scanner.nextLine().replaceAll("\\s+", "");
            neighborhood[row] = data.toCharArray();
            if (data.contains("S")) {
                rowSanta = row;
                colSanta = data.indexOf('S');
            }

            if (data.contains("V")) {
                niceKidsCounter += data.length() - data.replaceAll("V+", "").length();
            }
        }

        boolean ranOutOfPresents = false;

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning") && countPresents > 0) {
            int[] nextPosition = getPosition(rowSanta, colSanta, command);
            if (!isInBounds(nextPosition[0], nextPosition[1])) {
//                outOfNeighborhood = true;
                command = scanner.nextLine();
                continue;
            }
            neighborhood[rowSanta][colSanta] = '-';
            rowSanta = nextPosition[0];
            colSanta = nextPosition[1];

            char positionSymbol = neighborhood[rowSanta][colSanta];
            if (positionSymbol == 'V') {
                countPresents--;
                niceKidWithPresent++;
            }
            if (positionSymbol == 'C') {
                givePresentIfItPossible(getPosition(rowSanta, colSanta, "left"));
                givePresentIfItPossible(getPosition(rowSanta, colSanta, "right"));
                givePresentIfItPossible(getPosition(rowSanta, colSanta, "up"));
                givePresentIfItPossible(getPosition(rowSanta, colSanta, "down"));
            }

            neighborhood[rowSanta][colSanta] = 'S';

            if (countPresents <= 0) {
                ranOutOfPresents = true;
                if (niceKidsCounter - niceKidWithPresent == 0 && positionSymbol == 'C') {
                    ranOutOfPresents = false;
                }
                break;
            }
            command = scanner.nextLine();
        }

        if (ranOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }

        System.out.println(Arrays.stream(neighborhood)
                .map(row -> {
                    StringBuilder sb = new StringBuilder();
                    for (char symbol : row) {
                        sb.append(symbol + " ");
                    }
                    return sb.toString();
                })
                .collect(Collectors.joining(System.lineSeparator())));

        if (niceKidsCounter - niceKidWithPresent == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n", niceKidWithPresent);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n", niceKidsCounter - niceKidWithPresent);
        }

    }

    private static void givePresentIfItPossible(int[] position) {
        int row = position[0];
        int col = position[1];
        char positionSymbol = neighborhood[row][col];
        if (positionSymbol == 'V') {
            countPresents--;
            niceKidWithPresent++;
            neighborhood[row][col] = '-';
        }
        if (positionSymbol == 'X') {
            countPresents--;
            neighborhood[row][col] = '-';
        }

    }

    private static boolean isInBounds(int rowSanta, int colSanta) {
        return rowSanta >= 0 && rowSanta < neighborhood.length
                && colSanta >= 0 && colSanta < neighborhood[rowSanta].length;
    }

    private static int[] getPosition(int rowSanta, int colSanta, String command) {
        switch (command) {
            case "up":
                return new int[]{--rowSanta, colSanta};
            case "down":
                return new int[]{++rowSanta, colSanta};
            case "left":
                return new int[]{rowSanta, --colSanta};
            case "right":
                return new int[]{rowSanta, ++colSanta};
            default:
                return null;
        }

    }
}
