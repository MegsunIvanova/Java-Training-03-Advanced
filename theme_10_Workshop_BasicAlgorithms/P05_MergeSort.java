package theme_10_Workshop_BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sortedArr = mergeSort(arr);

        System.out.println(Arrays.stream(sortedArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));


    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        //initialize the two partitions of the array
        int halfIndex = arr.length / 2;

        int[] firstHalfArr = Arrays.copyOf(arr, halfIndex);
        int[] secondHalfArr = Arrays.copyOfRange(arr, halfIndex, arr.length);

        firstHalfArr = mergeSort(firstHalfArr);
        secondHalfArr = mergeSort(secondHalfArr);

        int mainindex = 0;
        int fIndex = 0;
        int sIndex = 0;
        while (fIndex < firstHalfArr.length && sIndex < secondHalfArr.length) {
            if (firstHalfArr[fIndex] < secondHalfArr[sIndex]) {
                arr[mainindex++] = firstHalfArr[fIndex++];
            } else {
                arr[mainindex++] = secondHalfArr[sIndex++];
            }
        }

        while (fIndex < firstHalfArr.length) {
            arr[mainindex++] = firstHalfArr[fIndex++];
        }

        while (sIndex < secondHalfArr.length) {
            arr[mainindex++] = secondHalfArr[sIndex++];
        }

        return arr;

    }
}
