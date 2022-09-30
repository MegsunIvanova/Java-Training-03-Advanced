package theme_08_Generics.Lab.P04_ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list =  List.of(13,42,69, 73);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
    }
}
