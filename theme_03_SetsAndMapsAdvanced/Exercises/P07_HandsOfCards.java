package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> powerMap = new HashMap<>();
        powerMap.put("2", 2);
        powerMap.put("3", 3);
        powerMap.put("4", 4);
        powerMap.put("5", 5);
        powerMap.put("6", 6);
        powerMap.put("7", 7);
        powerMap.put("8", 8);
        powerMap.put("9", 9);
        powerMap.put("10", 10);
        powerMap.put("J", 11);
        powerMap.put("Q", 12);
        powerMap.put("K", 13);
        powerMap.put("A", 14);

        Map<String, Integer> typesMap = new HashMap<>();
        typesMap.put("S", 4);
        typesMap.put("H", 3);
        typesMap.put("D", 2);
        typesMap.put("C", 1);

        Map<String, Set<String>> playersMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": |, ");
            String player = tokens[0];
            playersMap.putIfAbsent(player, new HashSet<>());

            for (int i = 1; i < tokens.length; i++) {
                playersMap.get(player).add(tokens[i]);
            }

            input = scanner.nextLine();
        }

        for (var entry : playersMap.entrySet()) {
            String player = entry.getKey();
            int totalValue = 0;
            for (String card : entry.getValue()) {
                String cardPower = card.substring(0, card.length() - 1);
                String cardType = card.charAt(card.length() - 1) + "";
                int cardValue = powerMap.get(cardPower) * typesMap.get(cardType);
                totalValue += cardValue;
            }

            System.out.println(player + ": " + totalValue);

        }

    }


}
