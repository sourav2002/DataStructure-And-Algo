package array;

//287. Find the Duplicate Number
//  Given an array of integers num containing n + 1 integers where each integer is in the range [1, n] inclusive.
//  There is only one duplicate number in num, return this duplicate number.

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        Arrays.sort(arr);
//        find(arr);
        System.out.println("duplicate no. is : " + find2(arr));
    }

    // time complexity is O(n log n )
    private static void find(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                int repeat = 2;
                if (arr[i + 1] == arr[i + 2]) {
                    repeat++;
                }
                if (!(repeat > 2)) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    // time complexity is O(n )
    private static int find2(int[] arr) {
        // traverse the array
        for (int i = 0; i < arr.length; i++) {
            //Return the absolute value
            int index = Math.abs(arr[i]);
            System.out.println("index : " + index);// just for understanding

//            if the number present in this index is negative its mean we have found duplicate
            if (arr[index] < 0) {
                return index;
            } else {
                // put a negative number
                arr[index] = -arr[index];
            }
        }

        return -1;
    }
}
