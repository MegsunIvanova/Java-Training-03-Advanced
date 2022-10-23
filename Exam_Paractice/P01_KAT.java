package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> platesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Long> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Long::parseLong)
                .forEach(carsStack::push);

        long totalRegisteredCars = 0;
        long days = 0;

        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;

            long platesForADay = platesQueue.poll();
            long carsForADay = carsStack.pop();

            if (platesForADay == carsForADay * 2) {
                totalRegisteredCars += carsForADay;
            } else if (platesForADay > carsForADay * 2) {
                totalRegisteredCars += carsForADay;
                long restOfPlates = platesForADay - carsForADay * 2;
                platesQueue.offer(restOfPlates);
            } else {
                totalRegisteredCars += platesForADay / 2;
                long restOfCars = carsForADay - platesForADay / 2;
                carsStack.addLast(restOfCars);
            }

        }

        System.out.printf("%d cars were registered for %d days!\n", totalRegisteredCars, days);
        if (!platesQueue.isEmpty()) {
            long platesRemain = platesQueue.stream().mapToLong(Long::longValue).sum();
            System.out.printf("%d license plates remain!\n", platesRemain);
        } else if (!carsStack.isEmpty()) {
            long carsRemain = carsStack.stream().mapToLong(Long::longValue).sum();
            System.out.printf("%d cars remain without license plates!\n", carsRemain);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
