//Minimum number of jumps
//        Medium Accuracy: 13.48% Submissions: 2706 Points: 4
//        Given an array of integers where each element represents the max number of steps that can
//        be made forward from that element. Write a function to return the minimum number of jumps to
//        reach the end of the array (starting from the first element). If an element is 0, then cannot
//        move through that element.


// Method 1: Naive Recursive Approach.
package array;

public class MinNoOfJump {
    // Returns minimum number of
    // jumps to reach arr[h] from arr[l]
    static int minJumps(int[] arr, int low, int high) {
        // Base case: when source
        // and destination are same
        if (high == low) {
            return 0;
        }

        // When nothing is reachable
        // from the given source
        if (arr[low] == 0) {
            return Integer.MAX_VALUE;
        }

//             Traverse through all the points
//             reachable from arr[l]. Recursively
//             get the minimum number of jumps
//             needed to reach arr[h] from these
//             reachable points.

        int minValue = Integer.MAX_VALUE;
        for (int i = low + 1; i <= high && i <= low + arr[low]; i++) {
            int jumps = minJumps(arr, i, high);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < minValue)
                minValue = jumps + 1;
        }
        return minValue;

    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "
                + minJumps(arr, 0, n - 1));
    }
}
