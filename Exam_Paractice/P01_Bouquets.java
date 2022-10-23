package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int stored = 0;

        //one bouquet needs 15 flowers, goal is to make at least 5 bouquets
        //crafting from the last tulips and the first daffodils
        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int sum = daffodilsQueue.peek() + tulipsStack.peek();
            if (sum <= 15) {
                if (daffodilsQueue.poll() + tulipsStack.pop() == 15) {
                    bouquets++;
                } else {
                    stored += sum;
                }

            } else {
                int currentTulips = tulipsStack.pop() - 2;
                tulipsStack.push(currentTulips);
            }
        }

        bouquets += stored / 15;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}
