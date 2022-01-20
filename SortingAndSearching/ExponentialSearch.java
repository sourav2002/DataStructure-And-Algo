package SortingAndSearching;

import java.util.Arrays;

public class ExponentialSearch {
    static int attempts = 0;

    // Returns position of
    // first occurrence of
    // x in array


    // first step is, step exponentially i.e i*2
    //    while array at index step is less than desired value
    //    than we do binary search from prev step to Math.min of next bigger index value of exponential step or
    //    size of array
    static int exponentialSearch(int arr[],
                                 int n, int x) {
        attempts++;
        // If x is present at first location itself
        if (arr[0] == x) {
            System.out.println("Total attempts taken :" + attempts);
            return 0;
        }

        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i * 2;
        System.out.println("Total attempts taken :" + attempts);


        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i / 2,
                Math.min(i, n - 1), x);
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 40;
        int result = exponentialSearch(arr,
                arr.length, x);

        System.out.println((result < 0) ?
                "Element is not present in array" :
                "Element is present at index " +
                        result);
    }
}
