package array;

import java.util.Arrays;

/*
next_permutation : find next lexicographically greater permutation
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically
 next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e.,sorted in ascending order).

Example 1 :
Input format: Arr[] = {1,3,2}
Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.

 */
public class NextLexicographic {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 2};
//        int[] a = {1, 3, 2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));

    }
    private static void nextPermutation(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int i = a.length - 2;  // -2 bcz we are checking i with its next index i.e i+1
        // we are using this condition to get the position of i from where
        // we have to make changes for example 13542, i will stop at number 3
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = a.length - 1; // last index
            while (a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1, a.length - 1);
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

/* Dry run -
Given array is { 1, 3, 5, 4, 2 }

1. special case if size of given array is 0 or 1 then simply return
2. run a loop where i starts from 2nd last index( because we are gonna count i and i+1)
   until a[i] > a[i+1] if yes , i--;
   1 ,3, 5, 4 ,2  (5 > 4 ? i--, so i is now at 3)
      i ( position of i according to condition i.e on 3  )

3. now create one more variable lets name it j and set the value of j = last index of array
   run a while loop until a[j] <= a[i] if yes j--
   1, 3, 5, 4, 2   (2 < 3 ? j--, so j is now on 4)
      i     j ( position of j )
   Because in ist iteration a[j] < a[i] which is 2 < 3 so j-- means j is now at 4 (2nd last index)

4. Now swap i and j index values with swap method -> 1, 4, 5, 3, 2
5. Now reverse the array from i+1 index to last index -> 1, 4,( 5, 3, 2) --> 1, 4, (2, 3, 5)
   This is the final answer now return it.

 */
