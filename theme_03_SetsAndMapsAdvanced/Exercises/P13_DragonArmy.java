package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P13_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragonsMap = new LinkedHashMap<>();
        //LinkedHashMap<type, TreeMap<name,   List<damage,  health,   armor>>>

        for (int i = 0; i < numberOfDragons; i++) {
            //"{type} {name} {damage} {health} {armor}"
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage = getDamage(input[2]);
            int health = getHealth(input[3]);
            int armor = getArmor(input[4]);
            List<Integer> statsList = new ArrayList<>();
            statsList.add(damage);
            statsList.add(health);
            statsList.add(armor);

            dragonsMap.putIfAbsent(type, new TreeMap<>());
            TreeMap<String, List<Integer>> currentDragonsMap = dragonsMap.get(type);
            currentDragonsMap.put(name, statsList);

        }

        for (var dragonTypeEntry : dragonsMap.entrySet()) {
            String type = dragonTypeEntry.getKey();
            double avgDamage = getAverageByIndex(dragonTypeEntry.getValue().values(), 0);
            double avgHealth = getAverageByIndex(dragonTypeEntry.getValue().values(), 1);
            double avgArmor = getAverageByIndex(dragonTypeEntry.getValue().values(), 2);
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avgDamage, avgHealth, avgArmor);

            for (var dragon : dragonTypeEntry.getValue().entrySet()) {
                String name = dragon.getKey();
                int damage = dragon.getValue().get(0);
                int health = dragon.getValue().get(1);
                int armor = dragon.getValue().get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", name, damage, health, armor);
            }

        }

    }

    private static double getAverageByIndex(Collection<List<Integer>> valuesLists, int index) {

        List<Integer> statsList = new ArrayList<>();
        valuesLists.forEach(stat -> statsList.add(stat.get(index)));
        int sum = statsList.stream().mapToInt(Integer::intValue).sum();
        double average = sum * 1.0 / statsList.size();
        return average;
    }

    private static int getDamage(String damage) {
        if (damage.equals("null")) {
            return 45;
        } else {
            return Integer.parseInt(damage);
        }
    }

    private static int getHealth(String health) {
        if (health.equals("null")) {
            return 250;
        } else {
            return Integer.parseInt(health);
        }
    }

    private static int getArmor(String armor) {
        if (armor.equals("null")) {
            return 10;
        } else {
            return Integer.parseInt(armor);
        }
    }
}
