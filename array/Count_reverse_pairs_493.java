package array;

import java.util.Arrays;

/*
Count Reverse Pairs
Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Examples:

Example 1:

Input: N = 5, array[] = {1,3,2,3,1)

Output: 2

Explanation: The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

 */
public class Count_reverse_pairs_493 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println(reversePairs(arr));
    }
    static int reversePairs(int[] nums){
        return mergeSort(nums, 0, nums.length-1);
    }

    private static int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
}
