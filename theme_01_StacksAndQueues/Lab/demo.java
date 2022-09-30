package theme_01_StacksAndQueues.Lab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {

        int[] arr = new int[]{73, 42, 69, 13};
        Scanner scanner = new Scanner(System.in);
        int element = Integer.parseInt(scanner.nextLine());
        int index = -1;

        //Constant operation O (1) -> HashMap<>
        // arr [2];

        // O(log(N)) ->
        // TreeMap<>
        //  BinarySearch

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        int memoryUse = Integer.BYTES * arr.length; // изчислява колко memory използва масива

        System.out.println(memoryUse);

        System.out.println(index);

    }
}
