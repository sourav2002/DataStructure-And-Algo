package SortingAndSearching;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr, int currIndex) {

        if (currIndex == arr.length) {
            return;
        }
        int a = currIndex;
        for (int i = currIndex - 1; i >= 0; i--) {
            if (arr[a] < arr[i]) {
//                int temp = arr[a];
//                arr[a] = arr[i];
//                arr[i] = temp;
                arr[a] = arr[a] + arr[i];
                arr[i] = arr[a] - arr[i];
                arr[a] = arr[a] - arr[i];
                a--;
            } else {
                break;
            }
        }

        insertionSort(arr, currIndex + 1);
    }

    public static void main(String[] args) {
        int[] arr = {33, 55, 2, 67, 34, 15, 76, 35};
        insertionSort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
