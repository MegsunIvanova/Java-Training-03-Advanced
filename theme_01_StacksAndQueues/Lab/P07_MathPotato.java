package theme_01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> circleQueue = new ArrayDeque<>();
        Collections.addAll(circleQueue, children);
        int cycle = 1;

        while (circleQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                circleQueue.offer(circleQueue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + circleQueue.peek());
            } else {
                System.out.println("Removed " + circleQueue.poll());
            }
            cycle++;
        }

        String lastKid = circleQueue.poll();
        System.out.println("Last is " + lastKid);
    }

    private static boolean isPrime(int cycle) {
        boolean isPrime = true;
        if (cycle < 2) {
            isPrime = false;

        } else {
            for (int i = 2; i < cycle; i++) {
                if (cycle % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;

    }

}

