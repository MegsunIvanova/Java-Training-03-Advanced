package theme_09_IteratorsAndComaparators.Exercises.Demos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String> {
    private List<String> fruits;

    public Shelf(String... fruits) {
        this.fruits = Arrays.asList(fruits);
    }

    @Override
    public Iterator<String> iterator() {
        return new ShopGirl();
    }

//    @Override
//    public Iterator<String> iterator() {
//
//        return new Iterator<String>() {
//            int index = 0;
//
//            @Override
//            public boolean hasNext() {
//                //Има ли още?
//                return index < fruits.size();
//            }
//
//            @Override
//            public String next() {
//                return fruits.get(index++);
//            }
//        };
//    }

    class ShopGirl implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            //Има ли още?
            return index < fruits.size();
        }

        @Override
        public String next() {
            return fruits.get(index++);
        }
    }
}
