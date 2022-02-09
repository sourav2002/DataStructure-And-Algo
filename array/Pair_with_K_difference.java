package array;

import java.util.HashMap;
import java.util.Map;

/*
532. K-diff Pairs in an Array
Medium
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
 */
public class Pair_with_K_difference {
    public static void main(String[] args) {
        int[] arr ={3,1,4,1,5};
        int k = 2;
        System.out.println(findPairs(arr, k));
    }
    static int findPairs(int[] arr, int k){
        if (arr == null || arr.length == 0 || k<0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr){
            map.put(i, map.getOrDefault(i,0) +1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (k ==0){
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            }else {
                if (map.containsKey(entry.getKey() + k)){
                    count++;
                }
            }
        }
        return count;
    }
}
/*
First Approach : Using HashMap

First we will create map for counting frequencies of each element in the array.

Now we have 2 cases over here as
-->a) if k == 0 it means we need to count frequency of the same element by using map.get(i) method.
-->b) we need to take counter approach for every element by adding k everytime and check whether that element is present in map or not.
 */