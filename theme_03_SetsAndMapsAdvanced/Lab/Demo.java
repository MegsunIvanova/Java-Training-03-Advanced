package theme_03_SetsAndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {

        //HashSet
        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(73);
        hashSet.add(13);
        hashSet.add(42);
        hashSet.add(69);

        System.out.println("HashSet: ");
        for (Integer e : hashSet) {
            System.out.println(e);
        }
        System.out.println();

        //TreeSet
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(73);
        treeSet.add(13);
        treeSet.add(42);
        treeSet.add(69);

        System.out.println("TreeSet: ");
        for (Integer e : treeSet) {
            System.out.println(e);
        }
        System.out.println();

        //LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(73);
        linkedHashSet.add(13);
        linkedHashSet.add(42);
        linkedHashSet.add(69);

        System.out.println("LinkedHashSet: ");
        for (Integer e : linkedHashSet) {
            System.out.println(e);
        }
        System.out.println();



        hashSet.remove(13);
        System.out.println(hashSet.contains(42) + " 42");
        System.out.println(hashSet.contains(13) + " 13");




    }
}
