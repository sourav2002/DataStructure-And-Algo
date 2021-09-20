package SortingAndSearching;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }else {
            return;
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {

        // because we have to change the original array so we need to copy it in temp array
        for (int i = low; i<= high; i++){
            temp[i] = arr[i];
        }

            int i = low;
            int j = mid+1;
            int k = low;
            while (i<= mid && j <= high){
                if (temp[i] <= temp[j]){
                    arr[k] = temp[i];
                    i++;
                }else {
                    arr[k] = temp[j];
                    j++;
                }
                k++;
            }
            while (i<= mid){
                arr[k] = temp[i];
                i++;
                k++;
            }
            while (j<= high ){
                arr[k] = temp[j];
                j++;
                k++;
            }
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 2, 9, 1, 45, 7, 34, 5};
        int[] temp = new int[arr.length];
        mergeSort(arr,temp,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
