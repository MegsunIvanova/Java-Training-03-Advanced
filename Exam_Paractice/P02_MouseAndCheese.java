package Exam_Paractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P02_MouseAndCheese {
    private static int rowMouse = -1;
    private static int colMouse = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //integer n -> size of the mouse territory with a square shape
        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];

        //n lines with the rows of the territory
        for (int row = 0; row < size; row++) {
            String rowData = scanner.nextLine();
            territory[row] = rowData.toCharArray();

            //mouse -> marked with 'M'
            if (rowData.contains("M")) {
                rowMouse = row;
                colMouse = rowData.indexOf('M');
            }
        }

        //cheese -> marked with 'c'
        //bonus -> marked with 'B'
        //empty positions -> marked with '-'

        boolean isMouseGone = false;
        int cheeseEaten = 0;

        //Each turn, you will be given a command for the mouse’s movement.
        //The commands will be: "up", "down", "left", "right", "end".
        //If the mouse receives the "end" command the program ends
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            territory[rowMouse][colMouse] = '-';
            moveMouse(command);

            if (!isInBounds(territory)) {
                //If the mouse goes out she can't return and the program ends.
                isMouseGone = true;
                break;
            }

            char currentSymbol = territory[rowMouse][colMouse];
            if (currentSymbol == 'c') {
                //If the mouse moves to cheese,
                // it eats the cheese and increases the cheese it has eaten by one.
                //(needs at least 5 eaten cheeses)
                cheeseEaten++;
            }
            if (currentSymbol == 'B') {
                //If it goes to a bonus,
                // the mouse gets a bonus one move forward and then the bonus disappears.
                territory[rowMouse][colMouse] = '-';
                moveMouse(command);
                if (territory[rowMouse][colMouse] == 'c') {
                    cheeseEaten++;
                }
            }

            territory[rowMouse][colMouse] = 'M';

            command = scanner.nextLine();
        }

        if (isMouseGone) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseEaten);
        }

        System.out.println(Arrays.stream(territory)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static void moveMouse(String command) {
        switch (command) {
            case "up":
                rowMouse--;
                break;
            case "down":
                rowMouse++;
                break;
            case "left":
                colMouse--;
                break;
            case "right":
                colMouse++;
                break;
        }

    }

    private static boolean isInBounds(char[][] territory) {
        return rowMouse >= 0 && rowMouse < territory.length
                && colMouse >= 0 && colMouse < territory[rowMouse].length;
    }
}
