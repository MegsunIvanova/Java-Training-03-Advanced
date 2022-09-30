package theme_08_Generics.Exercises.P11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String firstName = input[0];
        String secondName = input[1];
        String address = input[2];
        String town = input[3];
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(firstName + " " + secondName, address, town);
        System.out.println(threeuple1);

        input = scanner.nextLine().split(" ");
        String name = input[0];
        int liters = Integer.parseInt(input[1]);
        boolean isDrunk = input[2].equals("drunk");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, liters, isDrunk);
        System.out.println(threeuple2);

        input = scanner.nextLine().split(" ");
        String name3 = input[0];
        double balance = Double.parseDouble(input[1]);
        String bankName = input[2];
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(name3, balance, bankName);
        System.out.println(threeuple3);

    }
}
