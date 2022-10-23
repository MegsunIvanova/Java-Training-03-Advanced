package Exam_Paractice.P03_EasterBasket.src.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
            this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(egg -> egg.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return data.stream()
                .max(Comparator.comparingInt(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.material).append(" basket contains:").append(System.lineSeparator());
        sb.append(data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}