package array;

import java.util.Arrays;

/*
189. Rotate Array LEETCODE

Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

 */
public class RotateArrayByK_Steps {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("before array : "+ Arrays.toString(arr));
        rotate(arr, k);
        System.out.println("After rotating :" + Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length -1);
    }

    public static void reverse(int [] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
/*
approach -
1) rotate whole array
1234567 --> 7654321
2) rotate array by k steps from start
7654321 --> 567 4321
3) rotate array from k to last index
5674321 --> 567 1234
 */
