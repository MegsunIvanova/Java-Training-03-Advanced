package theme_09_IteratorsAndComaparators.Lab.P04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
                return firstBook.compareTo(secondBook);
    }
}
