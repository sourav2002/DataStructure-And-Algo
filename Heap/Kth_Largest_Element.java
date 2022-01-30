package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Kth_Largest_Element {
    public static void kLargest(Integer[] arr, int k) {
        Arrays.sort(arr, Collections.reverseOrder());

            System.out.print(arr[k-1] + " ");
    }

    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        Integer[] obj_array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(obj_array, Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>(k);

        for (int i = 0; i < k; i++)
            list.add(obj_array[i]);

        return list;
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        kLargest(arr, k);

        int[] prim_array = {1, 23, 12, 9, 30, 2, 50};
        System.out.print(kLargest(prim_array, k));
    }
}