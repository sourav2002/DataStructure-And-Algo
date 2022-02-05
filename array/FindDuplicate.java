package array;

//287. Find the Duplicate Number
//  Given an array of integers num containing n + 1 integers where each integer is in the range [1, n] inclusive.
//  There is only one duplicate number in num, return this duplicate number.

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        System.out.println("duplicate no. is : " + find2(arr));
    }

    // time complexity is O(n )
    // tortoise and hare algo (slow pointer fast pointer)
    private static int find2(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow != fast);

        fast = arr[0];
        while (slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
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

}
