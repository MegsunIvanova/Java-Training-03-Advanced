package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryMaterials = new HashMap<>();
        legendaryMaterials.put("shards",0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes",0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean isLegendaryItemObtained = false;
        String output = "";

        while (!isLegendaryItemObtained) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int index = 0; index < input.length; index += 2) {
                int quantity = Integer.parseInt(input[index]);
                String material = input[index + 1].toLowerCase(Locale.ROOT);
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    putMaterialInMap(material, quantity, legendaryMaterials);
                    if (legendaryMaterials.get(material) >= 250) {
                        isLegendaryItemObtained = true;
                        legendaryMaterials.put(material, legendaryMaterials.get(material) - 250);
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        }
                        if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        }
                        if (material.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        }
                    }
                } else {
                    putMaterialInMap(material, quantity, junkMaterials);
                }
                if (isLegendaryItemObtained) {
                    break;
                }
            }
        }

        legendaryMaterials.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getValue().compareTo(e1.getValue());
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        });

        for (var entry : junkMaterials.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }

    }

    private static void putMaterialInMap(String material, int quantity, Map<String, Integer> map) {
        map.putIfAbsent(material, 0);
        int newQuantity = map.get(material) + quantity;
        map.put(material, newQuantity);
    }
}
