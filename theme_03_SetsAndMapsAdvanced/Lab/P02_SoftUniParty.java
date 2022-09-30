package theme_03_SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String reservationNumber = scanner.nextLine();

        while (!reservationNumber.equals("PARTY")) {
            char startingSymbol = reservationNumber.charAt(0);
            boolean isVipRegistration = Character.isDigit(startingSymbol);
            guests.add(reservationNumber);
            reservationNumber = scanner.nextLine();
        }

        String guestReservation = scanner.nextLine();
        while (!guestReservation.equals("END")) {
            guests.remove(guestReservation);

            guestReservation = scanner.nextLine();
        }


        System.out.println(guests.size());
        if (!guests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), guests));
        }

    }
}
