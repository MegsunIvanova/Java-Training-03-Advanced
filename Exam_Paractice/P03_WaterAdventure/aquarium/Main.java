package Exam_Paractice.P03_WaterAdventure.aquarium;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize Aquarium
        Aquarium aquarium = new Aquarium("Ocean", 5, 15);

        // Initialize Fish
        Fish fish = new Fish("Goldy", "gold", 4);

        // Print Fish
        System.out.println(fish.toString());
        //Fish: Goldy
        //Color: gold
        //Number of fins: 4
        System.out.println("---");

        // Add Fish
        aquarium.add(fish);
        // Find Fish
        Fish fishFound1 = aquarium.findFish("Goldy");
        System.out.println(fishFound1);
        System.out.println("---");
        Fish fishFound2 = aquarium.findFish("Goldy2");
        System.out.println(fishFound2);
        System.out.println("---");

        // Get Fish in Pool
        System.out.println(aquarium.getFishInPool()); //1
        System.out.println("---");

        // Remove Fish
        System.out.println(aquarium.remove("Goldy")); // true
        System.out.println("---");

        Fish secondFish = new Fish("Dory", "blue", 2);
        Fish thirdFish = new Fish("Nemo", "orange", 5);

        // Add fish
        aquarium.add(secondFish);
        aquarium.add(thirdFish);

        // Print Aquarium report
        System.out.println(aquarium.report());

        //Aquarium Info:
        //Aquarium: Ocean ^ Size: 15
        //Fish: Dory
        //Color: blue
        //Number of fins: 2
        //Fish: Nemo
        //Color: orange
        //Number of fins: 5



    }
}
