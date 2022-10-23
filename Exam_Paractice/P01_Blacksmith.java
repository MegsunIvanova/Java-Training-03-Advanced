package Exam_Paractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //sequence representing steel
        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //sequence representing carbon
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);
        Map<String, Integer> swords = new TreeMap<>();

        //first steel mix with last carbon
        //You need to stop forging when you have no more steel or carbon left
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();

            //forge sword corresponding to the sum of their values and remove both:
            //Gladius 70
            //Shamshir 80
            //Katana 90
            //Sabre 110
            int sum = steel + carbon;
            String forgedSword = null;
            if (sum == 70) {
                forgedSword = "Gladius";
            } else if (sum == 80) {
                forgedSword = "Shamshir";
            } else if (sum == 90) {
                forgedSword = "Katana";
            } else if (sum == 110) {
                forgedSword = "Sabre";
            }

            //forge sword
            if (forgedSword != null) {
                swords.putIfAbsent(forgedSword, 0);
                int quantity = swords.get(forgedSword) + 1;
                swords.put(forgedSword, quantity);
            } // remove only the steel, increase the value of the carbon by 5
            //and insert it back into the collection
            else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        int totalNumberOfSwords = swords.values().stream().mapToInt(Integer::intValue).sum();
        if (totalNumberOfSwords > 0) {
            System.out.printf("You have forged %d swords.\n", totalNumberOfSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.println(steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(swords.entrySet().stream().map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
