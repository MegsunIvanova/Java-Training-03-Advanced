package theme_10_Workshop_BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P07_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());

        int index = getIndex(arr, key, 0, arr.length - 1);

        System.out.println(index);

    }

    private static int getIndex(int[] arr, int key, int start, int end) {
        //Binary search algorithm:
        // search algorithm that finds the position of a target value
        // within a sorted array.
        // Binary search compares the target value to the middle element of the array.
        // If they are not equal, the half in which the target cannot lie
        // is eliminated and the search continues on the remaining half,
        // again taking the middle element to compare to the target value,
        // and repeating this until the target value is found.

        while (end >= start) {
            int midIndex = (start + end) / 2;

            if (arr[midIndex] < key) {
                start = midIndex + 1;
            } else if (arr[midIndex] > key) {
                end = midIndex - 1;
            } else {
                //KEY IS FOUND
                return midIndex;
            }
        }

        //KEY NOT FOUND
        return -1;
    }
}
