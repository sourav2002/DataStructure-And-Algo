package SortingAndSearching;

import java.util.Arrays;

public class RadixSort {

    static void radixSort(int[] arr, int n) {
        // find the maximum number to know the number of digits
        int max = getMax(arr, n);
        int div;

        // The loop applies the count sort to the n th digit of the elements

        // here we are dividing our max number with div --> (1 , 10 ,100 )to the length of max number,
        // so we are multiplying div with 10 in every pass and also dividing with div
        for (div = 1; max / div > 0; div *= 10) {
            countSort(arr, n, div);
        }
    }

    private static void countSort(int[] arr, int size, int div) {
        int output[] = new int[size + 1];
        int max = getMax(arr, size);
        int count[] = new int[max + 1]; // because we have max 10 unique digits possible in mathematics
        int i;

        // storing frequency of digits in count array
        for (i = 0; i < size; i++)
            count[(arr[i] / div) % 10]++;


        // now we have to modify over count array which is we will add count[4] + count[3] in count[4]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // now we will create a new output array in which we are storing sorted values
        for (i = size - 1; i >= 0; i--) {
            // in next step we will store value in output array by decrement by 1
            output[count[(arr[i] / div) % 10] - 1] = arr[i];
            count[(arr[i] / div) % 10]--;
        }

        // now copy back output array in original array
        for (i = 0; i < size; i++)
            arr[i] = output[i];
    }

    private static int getMax(int[] arr, int size) {
        int max = arr[0];
        for (int i = 1; i < size - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {


        int[] arr = {3, 5, 24, 564, 23, 6, 3, 6, 5, 24, 1335, 45, 254};
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
