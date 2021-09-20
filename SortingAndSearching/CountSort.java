package SortingAndSearching;

import java.util.Arrays;

public class CountSort {

    static void countSOrt(int[] arr, int size){
        // 1st step --> we find the max element in array
        int maxInArray = arr[0];
        for (int i = 0; i< arr.length-1; i++){
            if (arr[i] > maxInArray){
                maxInArray = arr[i];
            }
        }

        // now we have to create count arr to store counting of every number,
        // but we can't declare the size of array dynamically

        int[] count = new int[size];
        //  now we are traversing to count frequency of numbers in array
        for (int i =0;i<size;i++){
            count[arr[i]]++;
        }

        // now we have to modify over count array which is we will add count[4] + count[3] in count[4]
        for (int i= 1;i <=maxInArray; i++){
            count[i] += count[i-1];
        }

        // now we will create a new output array in which we are storing sorted values
        int[] output = new int[size];
        for (int i = size-1; i >=0; i--){
            // in next step we will store value in output array by decrement by 1
            output[--count[arr[i]]]  = arr[i];
        }

        // now we will copy output array in original array
        for (int i=0; i< size-1; i++){
            arr[i] = output[i];
        }

    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,2,3,6,1,4,5};
        countSOrt(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
