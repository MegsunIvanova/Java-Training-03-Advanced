package theme_01_StacksAndQueues.Lab;


import java.util.Comparator;
import java.util.PriorityQueue;

public class demo_PriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.offer(42);
        queue.offer(13);
        queue.offer(73);
        queue.offer(69);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
