package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countWreaths = 0;
        int storedFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int sumOfFlowers = liliesStack.peek() + rosesQueue.peek();

            if (sumOfFlowers == 15) {
                //remove the flowers
                liliesStack.pop();
                rosesQueue.poll();
                countWreaths++;
            } else if (sumOfFlowers > 15) {
                int lilies = liliesStack.pop() - 2;
                liliesStack.push(lilies);
            } else {
                storedFlowers += liliesStack.pop() + rosesQueue.poll();
            }
        }

        countWreaths += storedFlowers / 15;

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", 5-countWreaths);
        }

    }
}
