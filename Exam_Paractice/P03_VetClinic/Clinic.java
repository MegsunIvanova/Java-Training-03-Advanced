package Exam_Paractice.P03_VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream()
                .max(Comparator.comparingInt(Pet::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:\n");
        sb.append(data.stream()
                .map(p -> p.getName() + " " + p.getOwner())
                .collect(Collectors.joining(System.lineSeparator())));

        return sb.toString();
    }

}

