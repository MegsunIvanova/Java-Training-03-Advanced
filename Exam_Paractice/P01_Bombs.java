package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(casingStack::push);

        Map<Integer, String> bombTypes = new HashMap<>();
        bombTypes.put(40, "Datura Bombs");
        bombTypes.put(60, "Cherry Bombs");
        bombTypes.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> createdBombs = new TreeMap<>();
        bombTypes.values().forEach(bombName -> createdBombs.put(bombName, 0));

        List<String> bombPouch = new ArrayList<>();

        while (!effectsQueue.isEmpty() && !casingStack.isEmpty() && bombPouch.size() < 3) {
            int mix = effectsQueue.peek() + casingStack.peek();
            if (bombTypes.containsKey(mix)) {
                String currentBomb = bombTypes.get(effectsQueue.poll() + casingStack.pop());
                int newQuantity = createdBombs.get(currentBomb) + 1;
                createdBombs.put(currentBomb, newQuantity);
                if (newQuantity == 3) {
                    bombPouch.add(currentBomb);
                }
            } else {
                int bombCasting = casingStack.pop() - 5;
//                if (bombCasting > 0) {
                    casingStack.push(bombCasting);
//                }
            }
        }

        if (bombPouch.size() == 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (casingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(casingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(createdBombs.entrySet().stream()
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
