package recursion;
/*
Count pairs with given sum
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
Example 1:
Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output = 2
Explanation:
arr[0] + arr[1] = 1 + 5 = 6
and arr[1] + arr[3] = 5 + 1 = 6.

Note : repetition of number is allowed.
 */
public class CountPairs {
    public static void main(String[] args) {
        int n = 3;
        int k = 6;
        int [] arr = {1,2,3};

        int ans = countF(0,n,k,arr);
        System.out.println("ans is ="+ans);
    }

    public static int countF(int ind, int n, int sum, int[] arr){

        if (sum == 0) return 1;
        if(ind == n){
            if(sum == 0) return 1;
            else return 0;
        }

        int left = 0;
        int right = 0;
        // when can you pick a particular index
        if(arr[ind] <= sum){
            // sum will decrement
            sum -= arr[ind];
            left = countF(ind, n,sum,arr);
            // restore sum
            sum += arr[ind];
        }
        right = countF(ind+1, n,sum,arr);
        return left+right;
    }
}
/*
whenever we find that we can add the value to get sum then we take that number and now search for less sum
 */
