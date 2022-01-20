package SortingAndSearching;

public class Sort_0s_1s_2s {
    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 0, 1, 1, 1, 2, 2, 0, 0, 1, 1, 2};
        Sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    private static void Sort(int[] arr) {
        int size = arr.length;
        int low = 0, mid = 0, high = size - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                // if the value is 0
                case 0 -> {
                    swap(arr, mid, low);
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }

    // swap method i.e used in sort method
    private static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}