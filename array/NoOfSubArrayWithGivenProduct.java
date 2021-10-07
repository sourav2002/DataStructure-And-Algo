import java.util.*;
 
class NoOfSubArrayWithGivenProduct
{
    // Function to find number of subarrays having
    // product exactly equal to k.
    public static int findSubarrayCount(int arr[], int n, int k)
    {
        int start = 0, endval = 0;
        int p = 1, countOnes = 0, res = 0;
        while(endval < n)
        {
            p *= (arr[endval]);
             
            // If product is greater than k then we need
            // to decrease it. This could be done by shifting
            // starting point of sliding window one place
            // to right at a time and update product accordingly.
            if (p > k)
            {
                while (start <= endval && p > k)
                {
                    p /= arr[start];
                    start++;
                }
            }
             
            if (p == k)
            {
                // Count number of succeeding ones.
                countOnes = 0;
                while (endval + 1 < n && arr[endval + 1] == 1)
                {
                    countOnes++;
                    endval++;
                }
                 
                // Update result by adding both new
                // subarray and effect of succeeding ones.
                res += (countOnes + 1);
                 
                // Update sliding window and result according
                // to change in sliding window. Here preceding
                // 1s have same effect on subarray as succeeding
                // 1s, so simply add.
                while (start <= endval && arr[start] == 1)
                {
                    res += (countOnes + 1);
                    start++;
                }
                 
                // Move start to correct position to find new
                // subarray and update product accordingly.
                p /= arr[start];
                start++;
            }
             
            endval++;
        }
        return res;
    }
     
    // Driver code
    public static void main (String[] args)
    {
        int arr[] = new int[]{ 2, 1, 1, 1, 4, 5 };
        int n = arr.length;
        int k = 4;
        System.out.println(findSubarrayCount(arr, n, k));
    }
}
