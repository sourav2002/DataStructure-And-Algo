package array;

import java.util.Arrays;
import java.util.Scanner;

/*
minimal difference between i and i-1
 */
public class MinimalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = result(arr, n);
        System.out.println(ans);
    }

    static int result(int [] arr, int n){
        Arrays.sort(arr);
        int sum = 0;
        sum += Math.abs(arr[0] - arr[1]);
        sum += Math.abs(arr[n-1]- arr[n-2]);

        for (int i = 1; i < n - 1; i++){
            sum += Math.min(Math.abs(arr[i] - arr[i-1]), Math.abs(arr[i] - arr[i+1]));
        }
        return sum;
    }
}
