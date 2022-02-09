package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class GridUniquePathByGoogle {
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 4, 5}, {2, 3, 7, 9}};

        System.out.println(countPath(arr.length, arr[0].length));
    }

    private static int countPath(int m, int n) {
        int N = m+n-2;
//        nCr
        int r = m-1;
        double res = 1;

        // 10C3 --> run i 0 ,1,2,3

        // 10c3 = 10x9x8/ 1x2x3

//         n-r+i --> 10 - 3 + 1 or 2 or 3 / 1 or 2 or 3
        for (int i = 1; i<= r; i++){
            res = res * (N - r + i)/ i;
        }
        return (int) res;
    }
}
