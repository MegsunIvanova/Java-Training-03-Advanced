package theme_06_DefiningClasses.Lab.P02_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        Car car;
        while (carsCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 1) {
                String brand = tokens[0];
                car = new Car(brand);
            } else {
                String brand = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsePower);
            }

            cars.add(car);


        }

        cars.forEach(c -> System.out.println(c.carInfo()));

    }
}
