package theme_09_IteratorsAndComaparators.Exercises.Demos;

import java.util.Iterator;

public class Main_IterableAndIterator {
    public static void main(String[] args) {

        Shelf shelf = new Shelf("Orange", "Banana", "Apple");
        Iterator<String> shopGirl = shelf.iterator();

        while (shopGirl.hasNext()) {
            System.out.println(shopGirl.next());
        }


    }
}
