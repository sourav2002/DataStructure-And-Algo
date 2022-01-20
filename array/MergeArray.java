package array;

import SortingAndSearching.SelectionSort;

import java.util.Arrays;

// solution -- https://www.youtube.com/watch?v=hVl2b3bLzBw
// https://en.wikipedia.org/wiki/Best,_worst_and_average_case
public class MergeArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 8, 10};
        int[] arr2 = {0, 2, 6, 8, 9};
//        merged1(arr1, arr2);
        merged2(arr1, arr2);
//        merged3(arr1, arr2);
    }

    // using 3rd array --space complexity will be
    private static void merged1(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int size3 = size1 + size2;
        int tempSize1 = size1;
        int[] arr3 = new int[size3];
        // copy array 1 into new array3
        System.arraycopy(arr1, 0, arr3, 0, size1);
        // copy array2 into new array 3
        for (int i : arr2) {
            arr3[tempSize1] = i;
            tempSize1++;
        }

        // sort array by using already defined class
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr3, size3);

        // now copy back all the elements of arr3 in arr1 and arr2
        System.arraycopy(arr3, 0, arr1, 0, size1);
        System.arraycopy(arr3, size1, arr2, 0, size2);

        // print array1 and array2
        System.out.print("array 1 is : ");
        for (int print : arr1) {
            System.out.print(print + " ");
        }
        System.out.println();
        System.out.print("array 2 is : ");
        for (int print : arr2) {
            System.out.print(print + " ");
        }

    }


    private static void merged2(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int temp;
        while (i < arr1.length) {
            if (arr1[i] > arr2[j]) {
                temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;
                Arrays.sort(arr1);
                Arrays.sort(arr2);
            }
        }
        System.out.print("array 1 is : ");
        for (int print : arr1) {
            System.out.print(print + " ");
        }
        System.out.println();
        System.out.print("array 2 is : ");
        for (int print : arr2) {
            System.out.print(print + " ");
        }
    }
}

