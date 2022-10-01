package theme_09_IteratorsAndComaparators.Exercises.P09_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        while (numberOfInputs-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            switch (command) {
                case "Add":
                    myLinkedList.add(number);
                    break;
                case "Remove":
                    myLinkedList.remove(number);
                    break;
            }

        }

        System.out.println(myLinkedList.size());

        for (Integer number : myLinkedList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
