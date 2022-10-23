package Exam_Paractice.P03_GroomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(" The grooming salon has the following clients:");
        sb.append(System.lineSeparator());
        sb.append(data.stream().map(pet -> String.format("%s %s", pet.getName(), pet.getOwner()))
                .collect(Collectors.joining(System.lineSeparator())));

        return sb.toString();
    }
}
