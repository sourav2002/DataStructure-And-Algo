package array;

import java.util.HashSet;
import java.util.Set;

/*
Longest Consecutive Sequence in an Array
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which
contains the consecutive elements.

Input: [100, 200, 1, 3, 2, 4]
Output: 4
Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String args[]) {
        int arr[] = {100, 200, 1, 2, 3, 4};
        int lon = longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is " + lon);
    }
}
/*
 put all numbers of array in a hashmap because it is easy to check if an array has x element or not
 now run a for loop and check if the number has not any previous value because we need consecutive sequence and it    requires 1st element to be smallest in the subset of consecutive seq.

 check if hashmap contains( current num + 1) if yes then update currentnum and increment current streak of sequence
*/

