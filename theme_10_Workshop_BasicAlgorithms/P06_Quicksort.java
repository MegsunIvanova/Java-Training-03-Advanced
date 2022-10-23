package theme_10_Workshop_BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_Quicksort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));


    }

    private static void sort(int[] arr, int low, int high) {
        ///* low  --> Starting index,  high  --> Ending index */

        if (low < high) {
            /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            //Recursively sort elements before
            //partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        /*This method takes last element as pivot
        places the pivot element at its correct
        position in sorted array, and places all
        smaller (smaller than pivot) to left of
        pivot and all greater elements to right
        of pivot*/
        int pivot = arr[high];
        int i = (low - 1);//index of smaller element
        for (int j = low; j < high; j++) {
            //if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                //swap arr[i] and arr[oldIndex]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //swap arr[i+1] and arr [high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;


    }


}
