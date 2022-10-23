package Exam_Paractice.P03_Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
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
        sb.append("The cars are parked in ").append(type).append(":");
        sb.append(System.lineSeparator());
        sb.append(data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
