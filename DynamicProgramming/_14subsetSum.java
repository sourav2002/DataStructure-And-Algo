/*
We are given an array ‘ARR’ with N positive integers. We need to find if there is a
subset in “ARR” with a sum equal to K. If there is, return true else return false.
 */

import java.util.Arrays;

public class _14subsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,4};
        int target = 4;

        System.out.println("Recursion : "+ solveRec(arr, target, arr.length-1));
        System.out.println("memoization : "+ solveMemo(arr,target,arr.length-1, new int[arr.length][target+1]));
        boolean[][] dp = new boolean[arr.length][target+1];
        System.out.println("tabulation : "+ solveTabu(arr,target,dp));
        System.out.println(Arrays.deepToString(dp));

    }

    private static boolean solveRec(int[]arr, int target, int i){
        if(target==0) return true;
        if(i == 0) return arr[i] == target;
        boolean take = false;
        if(arr[i] <= target)  take = solveRec(arr, target-arr[i], i-1);
        boolean not = solveRec(arr, target, i-1);

        return take | not;
    }

    // if false, then store in terms of -1 and if true, store in terms of +1
    private static boolean solveMemo(int[]arr, int target, int i, int[][] dp){
        if(target==0) return true;
        if(i == 0) return arr[i] == target;
        if(dp[i][target] != 0) return dp[i][target] == -1 ?  false :  true;
        boolean take = false;
        if(arr[i] <= target)  take = solveMemo(arr, target-arr[i], i-1, dp);
        boolean not = solveMemo(arr, target, i-1, dp);

        boolean ans =  take | not;
        dp[i][target] = (ans == true) ? 1 : -1;
        return ans;
    }


    private static boolean solveTabu(int[] arr, int target, boolean[][] dp){
        for(int i=0; i<arr.length; i++){

            dp[i][0] = true;
        }
        if(arr[0]<=target)
            dp[0][arr[0]] = true;
        for(int i=1; i<arr.length; i++){
            for (int j = 1; j<=target; j++){
                boolean take = false;
                if(arr[i] <= j)  take = dp[i-1][j-arr[i]];
                boolean not = dp[i-1][j];
                dp[i][j] = take|not;
            }
        }
        return dp[arr.length-1][target];
    }
}
