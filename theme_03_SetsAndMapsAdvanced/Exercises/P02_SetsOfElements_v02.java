package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstSetSize = setsSizes[0];
        int secondSetSize = setsSizes[1];

        Set<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }

        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);
        System.out.println(String.join(" ", firstSet));

    }
}
