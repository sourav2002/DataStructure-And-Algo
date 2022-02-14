package array;
/*
2170. Minimum Operations to Make the Array Alternating
Medium
You are given a 0-indexed array nums consisting of n positive integers.
The array nums is called alternating if:
nums[i - 2] == nums[i], where 2 <= i <= n - 1.
nums[i - 1] != nums[i], where 1 <= i <= n - 1.
In one operation, you can choose an index i and change nums[i] into any positive integer.
Return the minimum number of operations required to make the array alternating.

Input: nums = [3,1,3,2,4,3]
Output: 3
Explanation:
One way to make the array alternating is by converting it to [3,1,3,1,3,1].
The number of operations required in this case is 3.
It can be proven that it is not possible to make the array alternating in less than 3 operations.
 */
import java.util.HashMap;
import java.util.Map;

public class MinOperationToMakeArrayAlternative {
    public static void main(String[] args) {
        int[] arr = {3,1,3,2,5,2,3,6,8,2};
        System.out.println(minimumOperations(arr));
    }

    public static int minimumOperations(int[] nums) {
        int[] odd = getMax(nums, 0);
        int[] even = getMax(nums, 1);
        int n = nums.length;

        int oddFirstMax = odd[0], oddFirstFreq = odd[1], oddSecMax = odd[2], oddSecFreq = odd[3];
        int evenFirstMax = even[0], evenFirstFreq = even[1], evenSecMax = even[2], evenSecFreq = even[3];

        if (oddFirstMax == evenFirstMax) {
            return Math.min(n - evenSecFreq - oddFirstFreq, n - oddSecFreq - evenFirstFreq);
            // min btwn ( total nums - space occupied by even 1st maxFreq num - freq of 2nd maxfreq odd num) and vice versa
        } else {
            return n - oddFirstFreq - evenFirstFreq;
            // total nums - space occupied by all even and odd  maxFreq number
        }
    }

    private static int[] getMax(int[] nums, int idx) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = idx; i < nums.length; i += 2)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        int maxFreq = 0, maxVal = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) > maxFreq) {
                maxFreq = freq.get(key);
                maxVal = key;
            }
        }

        int maxSecFreq = 0, maxSecVal = 0;
        for (int key : freq.keySet()) {
            if (key == maxVal)
                continue;
            if (freq.get(key) > maxSecFreq) {
                maxSecFreq = freq.get(key);
                maxSecVal = key;
            }
        }

        return new int[]{maxVal, maxFreq, maxSecVal, maxSecFreq};
    }
}

/*
Why we want to get most freq number?
ans: so we keep the most freq number and only change the rest of number(even or odd) that we can get min result.

Why we need most second freq number?
ans: if odd and even has the same amount of freq number, we need to sacrifice one.

We prepare the most freq number and second most freq number for both odd and even sub array.

if odd most freq number == even most freq number, we need to look up the odd second most freq number and even second most freq number
if there are different, just calculate the result
note that (n + 1) is needed if nums.length is an odd number.
*/

