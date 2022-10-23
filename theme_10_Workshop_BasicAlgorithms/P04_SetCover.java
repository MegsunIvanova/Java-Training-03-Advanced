package theme_10_Workshop_BasicAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04_SetCover {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
//        List<Integer> universe = new ArrayList<>();
//        Arrays.stream(elements).map(Integer::parseInt).forEach(universe::add);
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<Integer> universeSet = new ArrayList<>();
        Arrays.stream(universe).forEach(universeSet::add);

        List<int[]> selectedSets = new ArrayList<>();

        while (!universeSet.isEmpty()) {
            //finds the one set with most elements contained in the universe
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int element : set) {
                    if (universeSet.contains(element)) {
                        count++;
                    }
                }

                if (count > notChosenCount) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }

            selectedSets.add(chosenSet);
            Arrays.stream(chosenSet).forEach(e -> universeSet.remove(Integer.valueOf(e)));
        }

        return selectedSets;
    }
}
