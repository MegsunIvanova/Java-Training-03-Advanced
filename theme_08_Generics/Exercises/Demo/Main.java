package theme_08_Generics.Exercises.Demo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Pesho");
        stringList.add("Gosho");
        stringList.add("Asen");
        System.out.println(min(stringList));


        List<Integer> numsList = new ArrayList<>();
        numsList.add(1);
        numsList.add(2);
        numsList.add(3);
        System.out.println(min(numsList));

    }

    public static <T extends Comparable> T min (List<T> list) {
        T min = list.get(0);
        for (T element : list) {
            if (min.compareTo(element) > 0) {
                min = element;
            }
        }
        return min;
    }
}
