
/*
 * Given a number of stairs and a frog, the frog wants to climb 
 * from the 0th stair to the (N-1)th stair. At a time the frog 
 * can climb either one or two steps. A height[N] array is also given. 
 * Whenever the frog jumps from a stair i to stair j, the energy 
 * consumed in the jump is abs(height[i]- height[j]), where abs() means
 *  the absolute difference. We need to return the minimum energy 
 * that can be used by the frog to jump from stair 0 to stair N-1.
 */

public class frogJump {
    
    public static void main(String[] args) {
        // int n = 4;
        // int [] arr = {10, 20, 30, 10};
        int n = 97;
        String ss = "27 35 43 34 27 19 7 38 16 18 46 13 14 50 34 38 36 34 26 39 6 41 23 1 33 30 45 13 47 13 22 20 3 1 17 26 45 39 22 45 21 11 30 44 36 45 29 27 39 42 40 35 46 31 21 6 31 50 20 50 10 10 24 6 30 29 44 39 42 14 23 12 4 1 35 5 45 40 44 42 47 24 48 16 21 50 34 4 13 5 36 46 20 45 3 13 7";
        String [] st  = ss.split(" ");
        int [] arr = new int[n];
        int i = 0;
        for(String s : st){
            arr[i++] = Integer.valueOf(s);
        }
        System.out.println(solveSpaceOpti(n-1, arr));
        System.out.println(solveMemo(n-1, arr, new int[n+1]));
        System.out.println(solveTabu(n-1, arr, new int[n+1]));
        System.out.println(solveRec(n-1, arr));
        
    }

    public static int solveRec(int n, int [] arr){
        if(n == 0) return 0;
        int diff1 = solveRec(n-1, arr) + Math.abs(arr[n] - arr[n-1]);
        int diff2 = Integer.MAX_VALUE;
        if(n > 1){
            diff2 = solveRec(n-2, arr) + Math.abs(arr[n] - arr[n-2]);
        }
        return Math.min(diff1, diff2);
     }

     public static int solveMemo(int n, int [] arr, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != 0) return dp[n];
        int diff1 = solveMemo(n-1, arr, dp) + Math.abs(arr[n] - arr[n-1]);
        int diff2 = Integer.MAX_VALUE;
        if(n > 1){
            diff2 = solveMemo(n-2, arr, dp) + Math.abs(arr[n] - arr[n-2]);
        }
        return dp[n] = Math.min(diff1, diff2);
     }

     public static int solveTabu(int n, int [] arr, int [] dp){
        dp[0] = 0;
        for(int i = 1; i<=n; i++){
            int diff1 = Math.abs(arr[i]- arr[i-1]) + dp[i-1];
            int diff2 = Integer.MAX_VALUE;
            if(i>1) diff2 = dp[i-2] + Math.abs(arr[i]- arr[i-2]);
            dp[i] = Math.min(diff1, diff2);
        }
        return dp[n];
     }

     public static int solveSpaceOpti(int n, int[] arr){
        int prev2 = 0;
        int prev1 = 0;
        for(int i=1; i<=n; i++){
            int diff1 = prev1 + Math.abs(arr[i]- arr[i-1]);
            int diff2 = Integer.MAX_VALUE;
            if(i>1) diff2 = prev2 + Math.abs(arr[i]- arr[i-2]);
            prev2 = prev1;
            prev1 = Math.min(diff1, diff2);
        }
        return prev1;

     }
}
