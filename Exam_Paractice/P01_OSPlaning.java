package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);
        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (tasksStack.peek() != taskToKill) {

            int thread = threadsQueue.poll();
            if (thread >= tasksStack.peek()) {
                int task = tasksStack.pop();
            }

        }

        System.out.printf("Thread with value %d killed task %d\n", threadsQueue.peek(), taskToKill);

        System.out.println(threadsQueue.stream().map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
