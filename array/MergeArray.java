package array;

import SortingAndSearching.SelectionSort;

import java.util.Arrays;

// solution -- https://www.youtube.com/watch?v=hVl2b3bLzBw
// https://en.wikipedia.org/wiki/Best,_worst_and_average_case

/*
Merge two Sorted Arrays Without Extra Space
Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so
that it contains the last M elements.
Examples:

Input:
n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two
non-decreasing arrays, we get,
1,2,3,4,8,9,10.

 */
public class MergeArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 8, 10};
        int[] arr2 = {0, 2, 6, 8, 9};
        System.out.println("Before merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
//        merged1(arr1, arr2);  // using extra array of size arr1 + arr2
//        merged2(arr1, arr2); // selection sort
        merged3(arr1, arr2); // gap method

        System.out.println();
        System.out.println("After merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

    // Gap Method
    private static void merged3(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        int gap =(int) Math.ceil((double)(n + m) / 2.0);
        while (gap > 0) {
            int i = 0;
            int j = gap;
            while (j < (n + m)) {
                if (j < n && arr1[i] > arr1[j]) {
                    swap(arr1[i], arr1[j]);
                } else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
                    swap(arr1[i], arr2[j - n]);
                } else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
                    swap(arr2[i - n], arr2[j - n]);
                }
                ++j;
                ++i;
            }
            if (gap == 1) {
                gap = 0;
            } else {
                gap =(int) Math.ceil((double) gap / 2.0);
            }
        }
    }
    static void swap(int a,int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    // using 3rd array --space complexity will be O(N)
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
    }
}

