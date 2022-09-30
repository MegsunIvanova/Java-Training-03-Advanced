package theme_08_Generics.Exercises.P09_CustomListIterator;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(values, index1, index2);
    }

    public long countGreaterThan(T element) {
        return this.values.stream()
                .filter(value -> value.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.values.stream()
                .max(Comparable::compareTo)
                .get();
    }

    public T getMin() {
        return this.values.stream()
                .min(Comparable::compareTo)
                .get();
    }

    public void print() {
        values.forEach(element -> System.out.println(element.toString()));
    }

    public int size() {
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(value);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            //Returns true if the array has more elements
            public boolean hasNext() {
                return this.currentIndex < values.size() && values.get(currentIndex) != null;
            }

            @Override
            //Returns the next element in the iteration.
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values.get(currentIndex++);
            }
        };
    }

}
