package Exam.P03_AnimalShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("The shelter has the following animals:");
        statistics.append(System.lineSeparator());
        statistics.append(data.stream()
                .map(a -> String.format("%s %s", a.getName(), a.getCaretaker()))
                .collect(Collectors.joining(System.lineSeparator())));

        return statistics.toString();
    }

}
