package Exam_Paractice.P03_CarDealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream()
                .max((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear()))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer)
                        && car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(name).append(":").append(System.lineSeparator());
        sb.append(data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
