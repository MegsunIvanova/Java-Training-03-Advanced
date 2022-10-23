package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_OSPlaning_vEP {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Contains all tha tasks in LIFO order
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int endTask = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int thread = threads.peek();

        while (task != endTask) {

            if (thread >= task) {
                tasks.pop();
            }

            threads.poll();

            task = tasks.peek();
            thread = threads.peek();
        }

        System.out.printf("Thread with value %d killed task %d\n", threads.peek(), endTask);

        String leftThreads = threads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(leftThreads);

    }
}
