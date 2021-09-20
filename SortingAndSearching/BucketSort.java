package SortingAndSearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    static void bucketSort(int[] arr,int n){
        int globalMax = getMax(arr,n);
        int globalMin = getMin(arr,n);
        int range = globalMax- globalMin;
        int bucketRange = (int) Math.ceil((double) range/n);
        // create bucket array
        List<Integer>[] buckets = new List[n];

        //Associate a list with each index in the bucket array
        for (int i =0; i< n;i++){
            buckets[i] = new LinkedList<>();
        }

        //Assign no. from array to the proper bucket by using hashing function
        for (int num : arr){
            buckets[num/bucketRange].add(num);
        }
        System.out.println(buckets[2]);


        // sort buckets
        for (List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }

        int idx =0;
        // merge buckets to get sorted array
        for (List<Integer> bucket : buckets){
            for (int num : bucket){
                arr[idx++] = num;
            }
        }

    }

    private static int getMax(int[] arr, int n) {

        int max = arr[0];
        for (int i = 0; i< n; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    private static int getMin(int[] arr, int n) {

        int min = arr[0];
        for (int i = 0; i< n; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,9,25,4,16,41,8};
        bucketSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
