package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<Integer, String> recipes = new HashMap<>();
        recipes.put(25, "Bread");
        recipes.put(50, "Cake");
        recipes.put(75, "Pastry");
        recipes.put(100, "Fruit Pie");

        Map<String, Integer> baked = new TreeMap<>();
        recipes.values().forEach(food -> baked.put(food, 0));

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int mix = liquid + ingredient;
            if (recipes.containsKey(mix)) {
                String food = recipes.get(mix);
                int newQuantity = baked.get(food) + 1;
                baked.put(food, newQuantity);
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }

        if (!baked.containsValue(0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        System.out.println(baked.entrySet().stream()
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
