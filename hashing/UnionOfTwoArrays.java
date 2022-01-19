package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {1,2,3,5};
        int[] b = {3,5,6,7};

        Map<Integer, Integer> map= Union(a,b);
        for (Integer name : map.keySet()) {
            System.out.print(name+" ");
        }
    }

    private static Map<Integer, Integer> Union(int[] a , int[] b){
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Inserting array elements in mp
        for(int i = 0; i < a.length; i++)
        {
            mp.put(a[i], i);
        }
        for(int i = 0; i < b.length; i++)
        {
            mp.put(b[i], i);
        }
        return mp;
    }

    private static int maxlength(int[]a , int[] b){
        int a1 =  a.length;
        int b1 = b.length;
        return Math.max(a1,b1);
    }
}
