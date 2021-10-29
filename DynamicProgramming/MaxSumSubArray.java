package DynamicProgramming;


// Kaden's algorithm
// Q- { 4, 3, -2, 6, -12, 7, -1, 6 }
// currentMax   |   maxSoFar    |   should I become part of current subArray OR Should I start a new subArray ?
//   4, {4}     |   4, {4}      |    any
//   7, {4,3}   |   7,{4,3}     |    current array will return sum 7 OR new array will return sum 3
//     ...      |               |
//     ...      |               |


import java.util.Arrays;

public class MaxSumSubArray {

    public static int maxSumSubArray(int[] arr) {
        // initialize current max and maxSumSOFar both with the value of 1st element
        int currentMax = arr[0];
        int maxSumSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {

            currentMax = currentMax + arr[i]; // Q-1 . element become part of current sub array

            if (currentMax < arr[i]) { // checking if should I became part of current sub array or make a new sub array
                currentMax = arr[i]; // Q-2 element decides to start its own array
            }

            // update max sum if current max became grater than maxSum So Far
            if (maxSumSoFar < currentMax ){
                maxSumSoFar = currentMax ;
            }
        }
        return maxSumSoFar;
    }

    public static int[] printMaxSumSubArray(int[] arr){
        // base case
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;

        // stores endpoints of maximum sum subarray found so far
        int start = 0, end = 0;
        // stores starting index of a positive-sum sequence when element decides to start its own array
        int beginning = 0;

        for (int i =0; i< arr.length; i++){
            currentMax = currentMax + arr[i];
            if (currentMax < arr[i]){
                currentMax = arr[i];
                beginning = i;   // beg is used to store the beginning index of new sub array
            }
            if (maxSoFar < currentMax){
                maxSoFar = currentMax;
                start = beginning; // now update the start point with beg which is updated beginning point of new sub array
                end = i; // store the current index as end point
            }
        }
        // now print the array using collection by using start and end point
            return Arrays.copyOfRange(arr, start, end + 1); // we are adding +1
        // bcz array starts from 0 and starting point is included and ending value is excluded
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, -2, 6, -12, 7, -1, 6};
        System.out.println(maxSumSubArray(arr));
        System.out.println(Arrays.toString(printMaxSumSubArray(arr)));
    }
}
