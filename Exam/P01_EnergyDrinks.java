package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeinеStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(caffeinеStack::push);

        ArrayDeque<Integer> energyDrinksQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int totalCaffeine = 0;

        while (!caffeinеStack.isEmpty() && !energyDrinksQueue.isEmpty()) {

            int currentDrinkCaffeine = caffeinеStack.peek() * energyDrinksQueue.peek();
            int caffeineLimit = 300 - totalCaffeine;

            if (currentDrinkCaffeine <= caffeineLimit) {
                caffeinеStack.pop();
                energyDrinksQueue.poll();
                totalCaffeine += currentDrinkCaffeine;
            } else {
                caffeinеStack.pop();
                int currentEnergyDrink = energyDrinksQueue.poll();
                energyDrinksQueue.offer(currentEnergyDrink);
                if (totalCaffeine >= 30) {
                    totalCaffeine -= 30;
                }
            }

        }

        if (!energyDrinksQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Drinks left: ");
            sb.append(energyDrinksQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println(sb.toString());
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);

    }
}
