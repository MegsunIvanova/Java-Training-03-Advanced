package theme_02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Demo_Arrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] predefinedArr = new int[n];

        for (int i = 0; i < predefinedArr.length; i++) {
            predefinedArr[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int middleIndex = arr.length / 2; //За масив с нечетен брой елементи

        int middleElement = arr[middleIndex];

        System.out.println(middleElement);

    }
}
