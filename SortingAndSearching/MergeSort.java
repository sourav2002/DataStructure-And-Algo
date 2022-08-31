package SortingAndSearching;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        } else {
            return;
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {

        // because we have to change the original array so we need to copy it in temp array
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int ind = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[ind] = temp[i];
                i++;
            } else {
                arr[ind] = temp[j];
                j++;
            }
            ind++;
        }
        while (i <= mid) {
            arr[ind] = temp[i];
            i++;
            ind++;
        }
        while (j <= high) {
            arr[ind] = temp[j];
            j++;
            ind++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 2, 9, 1, 45, 7, 34, 5};
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
