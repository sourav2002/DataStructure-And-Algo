package SortingAndSearching;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int index) {
        boolean swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }

            // if j loop did not swap any number than its mean array is already sorted,
            // so we don't need to execute code further
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 33, 6, 4, 1, 8, 2, 6, 9};
        bubbleSort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
