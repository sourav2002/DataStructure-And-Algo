import java.util.*;

/*
 * Given an array of ‘N’  positive integers, we need to return the maximum 
 * sum of the subsequence such that no two elements of the subsequence are 
 * adjacent elements in the array.
 */


public class sumOfNonAdjEle {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,5,10,8,2);
        int n = list.size();
        int[] dp = new int[n];
        System.out.println("space optimization : "+ solveSpaceOpti(list, n-1));
        System.out.println("tabulation : " + solveTabu(list, n-1, dp));
        System.out.println("memoization : " + solveMemo(list, n-1, dp));
        System.out.println("recursive : " + solveRec(list, n-1));
    }

    public static int solveRec(List<Integer> list, int i){
        if(i == 0) return list.get(0);
        if(i < 0) return 0;
        int pick = list.get(i) + solveRec(list, i-2);
        int nonpick = 0 + solveRec(list, i -1);
        return Math.max(pick, nonpick);
    }

    public static int solveMemo(List<Integer> list, int i, int[] dp){
        if(i == 0) return list.get(0);
        if(i < 0) return 0;
        if(dp[i] != 0) return dp[i];
        int pick = list.get(i) + solveMemo(list, i-2, dp);
        int nonpick = 0 + solveMemo(list, i -1, dp);
        return dp[i] = Math.max(pick, nonpick);
    }

    public static int solveTabu(List<Integer> list, int n, int[] dp){
        dp[0] = list.get(0);
        int getat1 = list.get(1);
        dp[1] = Math.max(dp[0], getat1);
        for(int i=2; i<= n; i++){
            int pick = list.get(i) + dp[i-2];
            int nonpick = dp[i-1] + 0;
            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n];
    }


    public static int solveSpaceOpti(List<Integer> list, int n){
        int two = list.get(0);
        int one = Math.max(list.get(0), list.get(1));
        for(int i=2; i<=n; i++){
            int pick = list.get(i) + two;
            int nonpick = 0 + one;
            two = one;
            one = Math.max(pick, nonpick);
        }
        return one;
    }
}
