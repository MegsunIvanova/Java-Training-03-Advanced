package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<Integer, String> recipes = new LinkedHashMap<>();
        recipes.put(25, "Biscuit");
        recipes.put(50, "Cake");
        recipes.put(100, "Pie");
        recipes.put(75, "Pastry");

        Map<String, Integer> cookedFood = new LinkedHashMap<>();
        recipes.values().forEach(value -> cookedFood.put(value, 0));


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;
            String food = recipes.get(sum);

            if (food != null) {
                int quantity = cookedFood.get(food) + 1;
                cookedFood.put(food, quantity);
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }

        if (!cookedFood.containsValue(0)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(cookedFood.entrySet().stream()
                .map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

}
