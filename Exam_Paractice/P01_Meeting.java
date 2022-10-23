package Exam_Paractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Meeting {
    static ArrayDeque<Integer> malesStack = new ArrayDeque<>();
    static ArrayDeque<Integer> femalesQueue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //sequence of integers representing males
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .forEach(malesStack::push);

        //sequence of integers representing females
        femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCount = 0;
        validateNextFemale();
        validateNextMale();

        //stop matching people when you have no more females or males
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int female = femalesQueue.poll();
            int male = malesStack.pop();

            if (female == male) {
                matchesCount++;
            } else {
                male -= 2;
                if (male > 0) {
                    malesStack.push(male);
                }
            }

            validateNextFemale();
            validateNextMale();

        }

        System.out.println("Matches: " + matchesCount);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(malesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femalesQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }


    }

    private static void validateNextFemale() {
        if (!femalesQueue.isEmpty()) {
            int female = femalesQueue.peek();
            if (female % 25 == 0) {
                for (int i = 0; i < 2; i++) {
                    if (!femalesQueue.isEmpty()) {
                        femalesQueue.poll();
                    }
                }
                validateNextFemale();
            }
        }
    }

    private static void validateNextMale() {
        if (!malesStack.isEmpty()) {
            int male = malesStack.peek();
            if (male % 25 == 0) {
                for (int i = 0; i < 2; i++) {
                    if (!malesStack.isEmpty()) {
                        malesStack.pop();
                    }
                }
                validateNextMale();
            }
        }
    }


}
