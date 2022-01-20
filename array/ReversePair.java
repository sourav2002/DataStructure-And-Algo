package array;


import java.util.ArrayList;

public class ReversePair {
    public static void main(String[] args) {
        int[] arr = {225, 111, 55, 27, 13, 6, 2};
        System.out.println(reversePair(arr));
    }

    public static int reversePair(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int inv = mergeSort(arr, low, mid);
        inv += mergeSort(arr, mid + 1, high);
        inv += merge(arr, low, mid, high);
        return inv;
    }

    static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > (2 * (long) arr[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= mid) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i < high; i++) {
            arr[i] = temp.get(i - low);
        }
        return count;
    }

}
