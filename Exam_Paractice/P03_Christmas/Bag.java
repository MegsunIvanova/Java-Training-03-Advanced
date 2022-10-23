package Exam_Paractice.P03_Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.data = new ArrayList<>();
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return data.stream().filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
//        String colorName = (color.charAt(0)+"").toUpperCase()+color.substring(1).toLowerCase();
        sb.append(color).append(" bag contains:").append(System.lineSeparator());
        sb.append(data.stream().map(Present::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }

}
