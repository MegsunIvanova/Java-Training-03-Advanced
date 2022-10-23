package Exam_Paractice.P03_WaterAdventure.aquarium;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Aquarium {

    //List<Fish> fishInPool;
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;  //the volume of the pool

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        String fishName = fish.getName();
        if (!fishInPool.containsKey(fishName) && fishInPool.size() < capacity) {
            fishInPool.put(fishName, fish);
        }
    }

    public boolean remove(String name) {
        return fishInPool.remove(name) != null;
    }

    public Fish findFish(String name) {
        return fishInPool.get(name);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(this.name)
                .append(" ^ Size: ").append(this.size).append(System.lineSeparator());
        sb.append(fishInPool.values().stream()
                .map(Fish::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
