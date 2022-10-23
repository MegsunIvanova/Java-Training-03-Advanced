package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondBoxStack::push);

        int sumOfClaimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.pop();
            int sumOfCurrentItems = firstItem + secondItem;
            if (sumOfCurrentItems % 2 == 0) {
                sumOfClaimedItems += firstBoxQueue.poll() + secondItem;
            } else {
                firstBoxQueue.offer(secondItem);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumOfClaimedItems);
        }
    }
}
