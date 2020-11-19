package array;
//N = 4
//        arr[] = {-1,-2,-3,-4}
//        Output: -1
//        Explanation: Max subarray sum is -1
//        of element (-1)
//        Your Task:
//        The task is to complete the function maxSubarraySum() which returns the sum of subarray with maximum sum.


public class KadaneAlgo {

    static int maxSubArraySum(int[] a)
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int j : a) {
            max_ending_here = max_ending_here + j;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
    public static void main(String[] args){

        int[] arr = {1,2,3,-9,5};
        maxSubArraySum(arr);

        System.out.println(maxSubArraySum(arr));
    }
}
