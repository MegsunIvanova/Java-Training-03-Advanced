package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        //"city|country|population"
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            populationMap.putIfAbsent(country, new LinkedHashMap<>());
            populationMap.get(country).put(city, population);

            input = scanner.nextLine();
        }

        populationMap.entrySet().stream().sorted((country1, country2) -> {
            long sum1 = country1.getValue().values().stream().mapToLong(Long::longValue).sum();
            long sum2 = country2.getValue().values().stream().mapToLong(Long::longValue).sum();
            return Long.compare(sum2, sum1);
        }).forEach(country -> {
            long sum = country.getValue().values().stream().mapToLong(Long::longValue).sum();
                    System.out.printf("%s (total population: %d)\n", country.getKey(), sum);
                    country.getValue().entrySet().stream().sorted((city1, city2) ->
                                    city2.getValue().compareTo(city1.getValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d\n", city.getKey(), city.getValue());
                            });

                }

        );

    }
}
