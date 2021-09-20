package SortingAndSearching;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] merge(int[] arr1, int[] arr2, int size1, int size2) {
        int[] result = new int[size1 + size2];
        // initialize i, j, k to traverse array
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size1 && j < size2) { // boundary condition
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        // either arr1 get exhausted or arr2 get exhausted

        while (i < size1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < size2) {
            result[k] = arr1[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 6, 12, 15, 18, 20};
        int[] arr2 = {1, 3, 7, 11, 13, 16, 19};
        int[] result = merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(result));
    }
}
