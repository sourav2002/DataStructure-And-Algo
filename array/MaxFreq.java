package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("put "+ n+" values of array");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("max freq number is : ");
        int ans = frequency(arr, n);
        System.out.println(ans);
    }
    static int frequency(int[] arr, int n){
        Arrays.sort(arr);
        int max_count = 1;
        int res = arr[0];
        int curr_count = 1;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr[i - 1];
                }
                curr_count = 1;
            }
        }
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr[n - 1];
        }
        return res;
    }
}
