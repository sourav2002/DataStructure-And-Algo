package array;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {
    public static void main(String[] args) {
        int [] arr = {9, -3, 3, -1, 6, -5};
        System.out.println(maxLen(arr));
    }
    static int maxLen(int [] arr){
        int n = arr.length;
        int sum =0, maxi = Integer.MIN_VALUE;
        HashMap<Integer, Integer> prefix = new HashMap<>();
        for(int i=0; i<n; i++){
            sum += arr[i];
            if (sum == 0){ // if prefix sum from 0th index to ith index return 0 then return i+1
                maxi = i+1;
            }else {
                if (prefix.get(sum) != null){
                    maxi = Math.max(maxi, i - prefix.get(sum));
                }else {
                    prefix.put(sum, i);
                }
            }
        }
        return maxi;
    }

}
/*
Length of the longest subarray with zero Sum
Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Example 1:

Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}

Result: 5

Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!
 */
