package array;

public class DutchNationalFlagAlgo {
    public static void main(String[] args) {
    int[] arr = {0, 0, 2, 0, 1, 1, 1, 2, 2, 0, 0, 1, 1, 2};
    Sort(arr);
    for (int i : arr) {
        System.out.print(i+" ");
    }
}

    private static void Sort(int[] arr) {
        int size = arr.length;
        int low = 0, mid = 0, high = size - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                // if the value is 0
                case 0 : {
                    swap(arr, mid, low);
                    low++;
                    mid++;
                    break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    swap(arr, mid, high);
                    high--;
                    break;
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
/*
Because we have only 3 numbers so we can store them into variables.
So create low, mid and high pointer
low = 0, mid = 1 , high = 2

initialize low and mid both with 0th index and high with last index of the array

all the numbers from
 0 to low-1 --> 0
 high+1 to end  --> 2

 all the elements toward left are 0 and all the elements toward right are 2s and between them is 1

 start a while loop while(mid <= high)
 now we will use switch case on mid-variable
 if mid = 0  --> swap arr[low] with arr[mid]
 and move the low and mid-pointer by 1

 if mid = 1 --> mid++;
 if mid - 2 --> swap arr[mid] with arr[high]
 and high--;
 (here we are not doing mid++ because when we swap mid with high then there is chances that value at high was 0
 if it is 0 then we have to swap it arr[low] with arr[mid]
 */
