package array;
/*
169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than [n / 2] times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int [] num = {2,2,1,1,1,2,2};
        int ans = majorityElement(num);
        System.out.println("Majority element is : " + ans);
    }
    private static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
