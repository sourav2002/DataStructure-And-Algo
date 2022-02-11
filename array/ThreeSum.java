package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
LeetCode #15
Given an integer array nums, Freturn all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < arr.length - 2; i++) { // till 3rd last index bcz triplet can't be same index value
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {  // arr[i] and arr[i-1] should not be same to avoid duplication
                int low = i + 1, high = arr.length - 1;
                while (low < high) {
                    int sum = arr[i] + arr[low] + arr[high];
                    if (sum == 0) {
                        res.add(Arrays.asList(arr[i], arr[low], arr[high]));
                        while (low < high && arr[low] == arr[low + 1]) low++;
                        while (low < high && arr[high] == arr[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum > 0) high--;
                    else low++;
                }
            }//end of if loop
        }// end of for loop
        return res;
    }
}
/*
Approach -
1) we will sort the array
-1,0,1,2,-1,-4  -->   -4,-1,-1,0,1,2

2) create a result list
3) iterate sorted array with for loop from 0 to 3rd last index ( triplets)
   in loop, check (*) special case if (i == 0 || (i > 0 && arr[i] != arr[i - 1]))
   arr[i] and arr[i-1] should not be same to avoid duplication
4) now keeping the 1st value constant, iterate in the array using 2 pointer algo where low pointer will start from
   i+1 index and high pointer will be at last element of the array.

   now traverse the array from i+1 index with while loop where low < high

   now check if (sum of all 3 elements == 0) add this triplet into res list
   (*) special case -   while (low < high && arr[low] == arr[low + 1])  -->   low++;
                        while (low < high && arr[high] == arr[high - 1]) -->  high--;
       check if while doing low++ or high--, next element should not be the same.

   if ( sum > 0) then high--
   if ( sum < 0) then low++ (according to 2 pointer algo)

   then finally return res (2nd step)
 */
