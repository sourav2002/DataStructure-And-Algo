package array;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
element appears at most twice. The relative order of the elements should be kept the same.
Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores)
 */
public class RemoveDuplicate2 {
    public static void main(String[] args) {
        int [] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println("Array before : "+ Arrays.toString(arr));
        int k = removeDuplicate(arr); // Calls your implementation
        int[] expectedArr = new int[k];
        assert k == expectedArr.length;
        for (int i = 0; i < k; i++) {
            assert arr[i] == expectedArr[i];
        }
        System.out.println("After implementation : "+Arrays.toString(arr));
    }
    static int removeDuplicate(int[] arr){
        int n = arr.length;
// if array contains 0 or 1 or 2 elements only then for sure there is not any duplicate elemetns with freq > 2
        if(n<3){
            return n;
        }

        // now take 2 pointer slow and fast start from index 2 (ignore 0 and 1 bcz no need to check for duplication)
        int s=2, f = 2;

        // fast pointer should not exceed the length of array
        while(f<n){
            if(arr[f] != arr[s-2]){
                arr[s++] = arr[f];
            }
            // dry run of if condition -
            // [1,1,1,2,2,3] -> slow and fast is at 2nd index, nums[2]== nums[0] (acc to if conditon) so increment f
            // now fast is at 3rd index ..nums[3] != nums[1] --> update nums[s] --> [1,1,(2),2,2,3] and s++, f++
            f++;
        }
        return s;
    }
}
