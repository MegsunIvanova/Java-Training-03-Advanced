package theme_06_DefiningClasses.Exercises.P03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();

        while (carsCount-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCostFor1km = Double.parseDouble(carInfo[2]);
            carsMap.put(model, new Car(model, fuelAmount, fuelCostFor1km));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandLine = input.split("\\s+");
            String model = commandLine[1];
            int amountOfKm = Integer.parseInt(commandLine[2]);
            Car car = carsMap.get(model);
            car.drive(amountOfKm);

            input = scanner.nextLine();
        }

        carsMap.values().forEach(System.out::println);

    }
}
