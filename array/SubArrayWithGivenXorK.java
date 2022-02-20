package array;

import java.util.*;

public class SubArrayWithGivenXorK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(xorCount(arr, k));
    }
    private static int xorCount(int[] arr, int k){
        int n = arr.length;
        int current_xor = 0;
        int count =0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for (int i=0; i<n;i++){
            current_xor = current_xor ^ arr[i];
            if(current_xor == k){
                count++;
            }
            if (prefix.containsKey(current_xor ^ k)) {
                count += prefix.get(current_xor ^ k);
            }
            prefix.put(current_xor, prefix.getOrDefault(current_xor, 0)+1);
        }
        return count;
    }
}
