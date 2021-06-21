package array;

import java.util.Arrays;

public class PairOfSum {
    public static void main(String[] args){
        int [] arr = {2,3,1,5,4,7,6,8,9,10};
        int sum = 11;
        Arrays.sort(arr);
        findPair(arr,sum);
    }

    private static void findPair(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            if (arr[start]+ arr[end] > x){
                end--;
            }else if (arr[start] + arr[end] < x){
                start++;
            }else {
                System.out.println(arr[start]+" "+ arr[end]);
                start++;
            }
        }
    }
}
