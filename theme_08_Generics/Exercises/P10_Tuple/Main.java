package theme_08_Generics.Exercises.P10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String firstName = input[0];
        String secondName = input[1];
        String address = input[2];
        Tuple<String, String> tuple1 = new Tuple<>(firstName+" "+secondName, address);
        System.out.println(tuple1);

        input = scanner.nextLine().split(" ");
        String name = input[0];
        int liters = Integer.parseInt(input[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(name, liters);
        System.out.println(tuple2);

        input = scanner.nextLine().split(" ");
        int intNumber = Integer.parseInt(input[0]);
        double doubleNumber = Double.parseDouble(input[1]);
        Tuple<Integer, Double> tuple3 = new Tuple<>(intNumber, doubleNumber);
        System.out.println(tuple3);

    }
}
