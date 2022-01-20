package extra;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 13, 3, 78, 2, 8};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.println("same  " + arr[i]);
            }
        }
        System.out.println(arr[arr.length - 2]);

    }
}
