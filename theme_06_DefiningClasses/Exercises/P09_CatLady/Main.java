package theme_06_DefiningClasses.Exercises.P09_CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Cat> cats = new ArrayList<>();

        while (!input.equals("End")) {
            String[] catInfo = input.split("\\s+");
            String breed = catInfo[0];
            String name = catInfo[1];
            double specificCharacteristic = Double.parseDouble(catInfo[2]);
            switch (breed) {
                case "Siamese":
                    cats.add(new Siamese(name, specificCharacteristic));
                    break;
                case "Cymric":
                    cats.add(new Cymric(name, specificCharacteristic));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(name, specificCharacteristic));
                    break;
            }

            input = scanner.nextLine();
        }

        String catName = scanner.nextLine();

        cats.stream().filter(cat -> cat.getName().equals(catName))
                .forEach(System.out::println);


    }
}
