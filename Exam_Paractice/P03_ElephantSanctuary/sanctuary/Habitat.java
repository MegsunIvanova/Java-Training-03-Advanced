package Exam_Paractice.P03_ElephantSanctuary.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    List<Elephant> data;
    int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add (Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);

        }
    }

    public boolean remove(String name) {
        List<Elephant> newData = data.stream().filter(e -> !e.getName().equals(name)).collect(Collectors.toList());
        if (newData.size() < data.size()) {
            data = newData;
            return true;
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        if (!data.isEmpty()) {
            return data.stream().max(Comparator.comparingInt(Elephant::getAge)).get();
        } else {
            return null;
        }
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:\n");
        sb.append(data.stream().map(e -> String.format("%s came from: %s", e.getName(), e.getRetiredFrom()))
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();

    }

}
