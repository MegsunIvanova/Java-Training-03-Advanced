package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_ItsChocolateTime {
    static Map<String, Integer> chocolatesProduced = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            long cacaoPercentage = 0;
            if (milk + cacao != 0) {
                cacaoPercentage = Math.round((cacao / (milk + cacao)) * 100);
            }

            String chocolateType = "";
            if (cacaoPercentage == 30) {
                chocolateType = "Milk Chocolate";
                addProducedChocolate(chocolateType);
            } else if (cacaoPercentage == 50) {
                chocolateType = "Dark Chocolate";
                addProducedChocolate(chocolateType);
            } else if (cacaoPercentage == 100) {
                chocolateType = "Baking Chocolate";
                addProducedChocolate(chocolateType);
            } else {
                milk += 10;
                milkQueue.offer(milk);
            }
        }

        if (chocolatesProduced.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        System.out.println(chocolatesProduced.entrySet().stream()
                .map(entry -> String.format("# %s --> %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));


    }

    private static void addProducedChocolate(String chocolateType) {
        chocolatesProduced.putIfAbsent(chocolateType, 0);
        int newQuantity = chocolatesProduced.get(chocolateType) + 1;
        chocolatesProduced.put(chocolateType, newQuantity);
    }
}
