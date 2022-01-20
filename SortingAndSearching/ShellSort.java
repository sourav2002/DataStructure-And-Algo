package SortingAndSearching;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] data = {9, 8, 3, 7, 5, 6, 4, 1};
        int size = data.length;
        ShellSort ss = new ShellSort();
        ss.shellSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

    void shellSort(int[] arr, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {  // j >= gap means 3 >= 2 ...
                    // we execute this statement if j-gap value is greater than j value
                    arr[j] = arr[j - gap];
                }
                // if arr[j - gap] is not greater than temp than execute arr[j] = temp
                // j is decreasing by j - gap in every iteration so j will we as small as possible,
                // now we will store temp at j
                arr[j] = temp;
            }
        }
    }

}
