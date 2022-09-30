package theme_08_Generics.Exercises.P04_GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            ;
            box.add(element);

        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        box.swap(indexes[0], indexes[1]);

        System.out.println(box);


    }
}
