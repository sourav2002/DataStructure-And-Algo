package array;

import java.util.*;
/*
18. 4Sum Medium
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
such that: 0 <= a, b, c, d < n ..... a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class FourSum {
    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ls = fourSum(arr, target);
        //System.out.println("raj");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;

        int n = num.length;
        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            int target_3 = target - num[i];

            for (int j = i + 1; j < n; j++) {
                int target_2 = target_3 - num[j];
                int front = j + 1;
                int back = n - 1;

                while (front < back) {
                    int two_sum = num[front] + num[back];
                    if (two_sum < target_2) front++;
                    else if (two_sum > target_2) back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;
                    }
                }
                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j]) ++j;
            }
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;
        }
        return res;
    }
}
/*
Approach
Intuition: In the previous approach we fixed three-pointers and did a binary search to find the fourth.
Over here we will fix two-pointers and then find the remaining two elements using two pointer technique
as the array will be sorted at first.

Approach: Sort the array, and then fix two pointers, so the remaining sum will be (target – (nums[i] + nums[j])).
Now we can fix two pointers, one front, and another back, and easily use a two-pointer to find the remaining two
numbers of the quad. In order to avoid duplications, we jump the duplicates, because taking duplicates will result
in repeating quads. We can easily jump duplicates, by skipping the same elements by running a loop.
 */
