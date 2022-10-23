package Exam_Paractice.P03_Parrots.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                parrot = p;
                break;
            }
        }
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sellData = new ArrayList<>();
        data.stream().filter(parrot -> parrot.getSpecies().equals(species))
                .forEach(parrot -> {
                    parrot.setAvailable(false);
                    sellData.add(parrot);
                });
        return sellData;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":")
                .append(System.lineSeparator());
        sb.append(data.stream().filter(Parrot::isAvailable)
                .map(Parrot::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }

}
