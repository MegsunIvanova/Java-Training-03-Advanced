package theme_01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (number != 0) {
            int binaryDigit = number % 2;
            stack.push(binaryDigit);
            number /= 2;
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            for (Integer integer : stack) {
                System.out.print(integer);
            }
        }

    }
}
