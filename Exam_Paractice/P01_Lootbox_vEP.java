package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Lootbox_vEP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        int loot = 0;

        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.pop();

            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                loot += sum;
            } else {
                firstBoxQueue.offer(secondBoxItem);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (loot >= 100) {
            System.out.println("Your loot was epic! Value: " + loot);
        } else {
            System.out.println("Your loot was poor... Value: " + loot);
        }
    }
}
