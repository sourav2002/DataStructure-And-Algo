package SortingAndSearching;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi-1);
            quickSort(arr, pi + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);

        // we are returning i+1 which means pivot value index
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i]+ arr[j];
//        arr[j] = arr[i] - arr[j];
//        arr[i] = arr[i] - arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }
}
