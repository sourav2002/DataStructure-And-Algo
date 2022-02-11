package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    public static int[] twoSum(int[] arr, int target){
        if (arr.length == 0 || arr == null){
            return new int[0];
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<arr.length;i++){
            if (map.containsKey(target-arr[i])){
                result[0] = map.get(target-arr[i]);
                result[1] = i;
                return result;
            }else {
                map.put(arr[i], i);
            }
        }
        return result;
    }
}
/*
Two Sum : Check if a pair with given sum exists in Array
Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers
such that their sum is equal to the target.

Note: Assume that there is exactly one solution, and you are not allowed to use the same element twice.
Example: If target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, which is the required target, we return indexes [0,1]. (0-based indexing)
 */