package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int officerRow = -1;
        int officerCol = -1;
        List<Integer> mirrorsList = new ArrayList<>();

        char[][] armory = new char[size][size];
        for (int row = 0; row < armory.length; row++) {
            String input = scanner.nextLine();
            armory[row] = input.toCharArray();
            //'A' -> army officer
            if (input.contains("A")) {
                officerRow = row;
                officerCol = input.indexOf('A');
            }
            //'M' -> mirrors (0 or 2)
            if (input.contains("M")) {
                mirrorsList.add(row);
                mirrorsList.add(input.indexOf('M'));
            }
        }

        int coins = 0;
        //The program ends when the army officer buys blades for at least 65 gold coins,
        // or you guide him out of the armory
        while (coins < 65) {
            String command = scanner.nextLine();
            int row = officerRow;
            int col = officerCol;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }

            //'-' -> empty position
            armory[officerRow][officerCol] = '-';
            if (!isInBounds(row, col, armory)) {
                //the army officer leaves the armory
                break;
            }

            char currentPositionSymbol = armory[row][col];

            //digit (price of the sword) -> sword
            if (Character.isDigit(currentPositionSymbol)) {
                coins += Character.getNumericValue(currentPositionSymbol);
                officerRow = row;
                officerCol = col;
            }

            if (currentPositionSymbol == 'M') {
                if (row == mirrorsList.get(0) && col == mirrorsList.get(1)) {
                    officerRow = mirrorsList.get(2);
                    officerCol = mirrorsList.get(3);
                    armory[row][col] = '-';
                } else if (row == mirrorsList.get(2) && col == mirrorsList.get(3)) {
                    officerRow = mirrorsList.get(0);
                    officerCol = mirrorsList.get(1);
                    armory[row][col] = '-';
                }
            }

            if (currentPositionSymbol == '-') {
                officerRow = row;
                officerCol = col;
            }

            armory[officerRow][officerCol] = 'A';
        }

        if (coins < 65) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.\n", coins);
        for (int row = 0; row < armory.length; row++) {
            System.out.println(Arrays.asList(armory[row])
                    .stream().map(String::valueOf)
                    .collect(Collectors.joining("")));
        }

    }

    private static boolean isInBounds(int row, int col, char[][] armory) {
        return row >= 0 && row < armory.length && col >= 0 && col < armory.length;
    }
}
