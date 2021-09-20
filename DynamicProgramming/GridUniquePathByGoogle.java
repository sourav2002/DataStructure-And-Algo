package DynamicProgramming;

import java.util.Vector;

public class GridUniquePathByGoogle {
    public static void main(String[] args) {
        int [] [] arr = {{2,3,4,5}, {2,3,7,9}};
    }
    private int countPath(int i, int j, int n, int m, Vector<Vector<Integer>> dp ){
        if (i == n-1 && j == m-1) return 1;
        if (i >=n || j >= m) return 0;

        // using dp
        if (dp.get(i).get(j) != -1) return dp.get(i).get(j);
//        else return dp.set(i).set(j) = countPath(i + 1, j, n, m, dp) + countPath(i, j + 1, n, m, dp);
        return 0;// error
    }
}
