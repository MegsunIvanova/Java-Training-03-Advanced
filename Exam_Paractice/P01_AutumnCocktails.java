package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessStack::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            if (ingredientsQueue.peek() == 0) {
                //remove it
                int elementForRemove = ingredientsQueue.poll();
                continue;
            }

            int ingredient = ingredientsQueue.poll();
            int freshness = freshnessStack.pop();

            int levelOfFreshness = ingredient * freshness;
            String cocktail;
            switch (levelOfFreshness) {
                case 150:
                    cocktail = "Pear Sour";
                    break;
                case 250:
                    cocktail = "The Harvest";
                    break;
                case 300:
                    cocktail = "Apple Hinny";
                    break;
                case 400:
                    cocktail = "High Fashion";
                    break;
                default:
                    cocktail = "cantMix"
     ;               break;
            }

            if (!cocktail.equals("cantMix")) {
                cocktails.putIfAbsent(cocktail, 0);
                int quantity = cocktails.get(cocktail) + 1;
                cocktails.put(cocktail, quantity);
            } else {
                ingredient += 5;
                ingredientsQueue.offer(ingredient);
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }


        int sumOfIngredients = ingredientsQueue.stream()
                .mapToInt(Integer::intValue).sum();
        if (sumOfIngredients > 0) {
            System.out.println("Ingredients left: " + sumOfIngredients);
        }

        if (cocktails.size() > 0) {
            System.out.println(cocktails.entrySet().stream()
                    .map(entry -> String.format(" # %s --> %d", entry.getKey(), entry.getValue()))
                    .collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
