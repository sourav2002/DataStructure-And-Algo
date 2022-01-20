package array;

import java.util.Arrays;

public class RotateArrayByDElement2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;
        leftRotate(arr, d);
        printArray(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));

    }

    private static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
    }

    private static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        if (d == 0) return;
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
