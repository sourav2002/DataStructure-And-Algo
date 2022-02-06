package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:

Input: nums = [3,2,3]
Output: [3]
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        int[] num = {3, 2, 3, 2, 2, 3, 1};
        System.out.println(majorityElement(num));
    }

    private static List<Integer> majorityElement(int[] num) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, n = num.length;
        for (int i = 0; i < n; i++) {
            if (num[i] == num1) {
                count1++;
            } else if (num[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i=0; i<n; i++){
            if (num[i] == num1){
                count1++;
            }else if(num[i] == num2){
                count2++;
            }
        }

        if(count1 > n/3) ans.add(num1);
        if (count2 > n/3) ans.add(num2);

        return ans;

    }
}
/*
at max, you can have 2 majority elements and min, u have 0 (1/3 means more than 33.3% , 34% + 34% + 3rd not possible)
initially , num1 and num2 is set to -1,  now while traversing array, 1st element is given to num1 and increment count1
if 2nd element of array is also same as num1 then increment count1 otherwise set num2 = 2nd element and count2++;

if 3rd element is equal to num1 or num2 then increment count1 or count2 accordingly OR if 3rd (any element is not equal
to num1 or num2 then decrement both count1 and count2 by 1;

now following 3rd step, if at any index of array, the value of count1 or count2 == 0 then replace num1 or num2 with
current element accordingly.

after iterating the array, we will get num1 and num2. Now run a for loop to count the freq of num1 and num2

if freq of num1 or num2 is greater than 1/3, then add that number in arraylist and return the arraylist
 */
