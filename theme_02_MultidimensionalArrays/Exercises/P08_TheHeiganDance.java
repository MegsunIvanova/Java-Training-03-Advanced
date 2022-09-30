package theme_02_MultidimensionalArrays.Exercises;

import java.util.Scanner;


public class P08_TheHeiganDance {
    private static int rowPlayer;
    private static int colPlayer;
    private static boolean[][] chamber = new boolean[15][15];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganHitPoints = 3000000.0;
        int playerHitPoints = 18500;

        rowPlayer = 7;
        colPlayer = 7;

        String spell = "";
        boolean isActivePlagueCloud = false;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        int cloudDamage = 3500;
        int eruptionDamage = 6000;


        while (heiganHitPoints >= 0 && playerHitPoints >= 0) {
            heiganHitPoints -= playerDamage;

            if (isActivePlagueCloud) {
                playerHitPoints -= cloudDamage;
                isActivePlagueCloud = false;
            }

            if (playerHitPoints <= 0 || heiganHitPoints <= 0) {
                break;
            }

            createNewChamber();
            String[] heiganTurnInput = scanner.nextLine().split("\\s");
            spell = heiganTurnInput[0];
            int rowSpell = Integer.parseInt(heiganTurnInput[1]);
            int colSpell = Integer.parseInt(heiganTurnInput[2]);
            blockCells(rowSpell, colSpell);

            if (isPlayerOnSpellArea()) {
                tryToMoveThePlayer();
                if (isPlayerOnSpellArea()) {
                    if (spell.equals("Cloud")) {
                        playerHitPoints -= cloudDamage;
                        isActivePlagueCloud = true;
                    } else if (spell.equals("Eruption")) {
                        playerHitPoints -= eruptionDamage;
                    }
                }
            }

        }


        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            if (spell.equals("Cloud")) {
                spell = "Plague Cloud";
            }
            System.out.printf("Player: Killed by %s\n", spell);
        } else {
            System.out.printf("Player: %d\n", playerHitPoints);
        }
        System.out.printf("Final position: %d, %d\n", rowPlayer, colPlayer);

    }

    private static void createNewChamber() {
        for (int row = 0; row < 15; row++) {
            chamber[row] = new boolean[15];
            for (int col = 0; col < 15; col++) {
                chamber[row][col] = true;
            }
        }
    }

    private static void blockCells(int rowSpell, int colSpell) {
        for (int row = rowSpell - 1; row <= rowSpell + 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (isInBounds(row, col) && chamber[row][col]) {
                    chamber[row][col] = false;
                }
            }
        }

    }

    private static void tryToMoveThePlayer() {

        if (isInBounds(rowPlayer - 1, colPlayer) && chamber[rowPlayer - 1][colPlayer]) {
            rowPlayer--; //move up
        } else if (isInBounds(rowPlayer, colPlayer + 1) && chamber[rowPlayer][colPlayer + 1]) {
            colPlayer++;//move right
        } else if (isInBounds(rowPlayer + 1, colPlayer) && chamber[rowPlayer + 1][colPlayer]) {
            rowPlayer++;//move down
        } else if (isInBounds(rowPlayer, colPlayer - 1) && chamber[rowPlayer][colPlayer - 1]) {
            colPlayer--;//move left
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < chamber.length && col >= 0 && col < chamber[row].length;
    }

    private static boolean isPlayerOnSpellArea() {
        return !chamber[rowPlayer][colPlayer];
    }


}

