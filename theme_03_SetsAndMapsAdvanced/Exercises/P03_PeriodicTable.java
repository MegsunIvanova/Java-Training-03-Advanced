package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compound = scanner.nextLine().split("\\s+");
            Collections.addAll(chemicalElements, compound);
        }

        System.out.println(String.join(" ", chemicalElements));

    }
}
