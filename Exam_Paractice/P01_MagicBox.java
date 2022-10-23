package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int claimedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.peek();

            int summedItems = firstItem + secondItem;
            if (summedItems % 2 == 0) {
                claimedItems += firstBox.poll() + secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }

    }
}
