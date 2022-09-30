package theme_01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> circleQueue = new ArrayDeque<>();
        Collections.addAll(circleQueue, children);

        while (circleQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentKid = circleQueue.poll();
                circleQueue.offer(currentKid);
            }
            String kidWhoLivesGame = circleQueue.poll();
            System.out.println("Removed " + kidWhoLivesGame);
        }

        String lastKid = circleQueue.poll();
        System.out.println("Last is " + lastKid);
    }
}
