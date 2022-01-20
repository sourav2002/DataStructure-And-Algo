//Given an array arr[] denoting heights of N towers and a positive integer K, you have to
// modify the height of each tower either by increasing or decreasing them by K only once.
// After modifying, height should be a non-negative integer.
//        Find out what could be the possible minimum difference of the height of
//        shortest and longest towers after you have modified each tower.
//
//        Example 1:
//
//        Input:
//        K = 2, N = 4
//        Arr[] = {1, 5, 8, 10}
//        Output: 5
//        Explanation: The array can be modified as
//        {3, 3, 6, 8}. The difference between
//        the largest and the smallest is 8-3 = 5.
package array;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of K : ");
        int k = sc.nextInt();
        System.out.print("Enter no. of Towers: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter heights of towers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Minimum sum is : " + MinimumSum(arr, k, n));
    }

    private static int MinimumSum(int[] arr, int k, int n) {
        if (n == 1)
            return 0;

        // Sort all elements
        Arrays.sort(arr);

        // Initialize result
        int ans = arr[n - 1] - arr[0];

        // Handle corner elements
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            // If both subtraction and addition
            // do not change diff
            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller
            // number or addition causes a greater
            // number. Update small or big using
            // greedy approach (If big - subtract
            // causes smaller diff, update small
            // Else update big)
            if (big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }

        return Math.min(ans, big - small);
    }
}


