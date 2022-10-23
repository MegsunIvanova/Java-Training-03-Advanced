package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SantaSPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(n -> n != 0)
                .forEach(materialsStack::push);
        ArrayDeque<Integer> magicQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(n -> n != 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<Integer, String> presentsData = new HashMap<>();
        presentsData.put(150, "Doll");
        presentsData.put(250, "Wooden train");
        presentsData.put(300, "Teddy bear");
        presentsData.put(400, "Bicycle");
        Map<String, Integer> craftedPresents = new TreeMap<>();

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) {
            int material = materialsStack.peek();
            int magic = magicQueue.peek();
            int product = material * magic;

            if (presentsData.containsKey(product)) {
                materialsStack.pop();
                magicQueue.poll();
                String present = presentsData.get(product);
                craftedPresents.putIfAbsent(present, 0);
                int quantity = craftedPresents.get(present) + 1;
                craftedPresents.put(present, quantity);

            } else if (product < 0) {
                int sum = materialsStack.pop() + magicQueue.poll();
                if (sum != 0) {
                    materialsStack.push(sum);
                }

            } else if (product > 0) {
                magicQueue.poll();
                int materialIncreased = materialsStack.pop() + 15;
                if (materialIncreased != 0) {
                    materialsStack.push(materialIncreased);
                }
            }

        }

        if (haveSuccess(craftedPresents)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materialsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (!magicQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        System.out.println(craftedPresents.entrySet().stream()
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static boolean haveSuccess(Map<String, Integer> craftedPresents) {
        if (craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train")) {
            return true;
        }
        if (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle")) {
            return true;
        }
        return false;
    }
}
