package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraysSumEqualK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(subArraySum(arr, k));
    }

    public static int subArraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // bcz cumulative sum requires i-1th index value
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
/*
560. Subarray Sum Equals K   (Medium)
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

✔️3️⃣ Approach 3: HashMap O(n)| O(n) (Optimal) 🦞
This is optimal solution since we only iterate through nums once.

Step 1: Init sumHash = {0:1} where every key in hashMap indicate sum from index 0 to current index
Value of hashMap is counting times the sum number in previous nums.

Step 2: Iterate through nums and sum up accumulative numbers, Once we found currentSum - k in hashmap, means there is a subarray from the target to currrent index and add up count

NOTE: Since we want return count to the subarray, we don't have to worry about which index form the subarray. We only care how many times a certain sum in previous we store in hashMap.
Complexity Analysis
Time: O(n) : Let n be length of nums.
Space: O(n) : We using extra space store sumHash
 */
