package array;

import java.util.Arrays;

/*
66. Plus One    Leetcode 66

You are given a large integer represented as an integer array digits, where each digits[i] is theith digit of the
integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer
does not contain any leading 0's.Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
//        int[] arr = {9};
//        int[] arr = {9,9,9};

        int[] res = plusone(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] plusone(int[] digits){
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
/*
start loop from the last of array
and add one in the ith element
then check if the number(after adding one)is <= 9
if (num <=9) then return arr;
1,2,3 --> last number was 3. After adding one into it, i.e 4 (4<=9) return 1,2,4

9,9 -->  last number was 9. After adding 1 in 9, it becomes 10 and (10<=9) condition fails
so now make that index number = 0 i.e ith index value 10 --> 0
now if next value is again 9 then we will repeat all the steps again

after that we will make a new array having length = length of old array + 1;
and make it 1st index value = 1;
and return it
 */
