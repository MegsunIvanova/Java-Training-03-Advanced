package theme_09_IteratorsAndComaparators.Lab.Demos;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        printT();

        printT("Hello");

        printT("Hello", "World");

        printT("Hello", "World", "!");

        printT(13, "World", "!");

    }

    public static <T> void printT(T... values) {

        if (values.length == 0) {
            System.out.println("Please add inout");
            return;
        }
        Arrays.stream(values).forEach(System.out::println);
    }

}
