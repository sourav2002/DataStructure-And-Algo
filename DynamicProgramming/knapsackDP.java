
/*
A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items.
Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include
an item in its knapsack or exclude it but can’t partially have it as a fraction. We need to find
the maximum value of items that the thief can steal.
 */
public class _19Knapsack {
    public static void main(String[] args) {
        int n = 4;
        int [] w = {2, 2, 5, 5};
        int [] v ={20, 20, 30, 60};
        int size = 10;

        int[][] dp = new int[n][size+1];
        System.out.println("rec : "+ rec(n-1, size, w, v));
        System.out.println("memo : "+ memo(n-1, size, w,v,dp));
        System.out.println("tabu : "+ tabu(n, size,w,v));
        System.out.println("space : "+ space(n, size, w,v));
    }

    public static int rec(int n, int size, int[] w, int[] v){
        if(n == 0){
            if(w[0] <= size) return v[0];
            return 0;
        }

        int not = 0+  rec(n-1, size, w,v);
        int take = 0;
        if(w[n] <= size) take = v[n] + rec(n-1, size - w[n], w,v);

        return Math.max(take , not);
    }

    public static int memo(int n, int size, int[] w, int[] v, int[][] dp){
        if(n == 0){
            if(w[0] <= size) return v[0];
            return 0;
        }
        if(dp[n][size] != 0) return dp[n][size];
        int not = memo(n - 1, size, w, v, dp);
        int take = 0;
        if(w[n] <= size) take = v[n] + memo(n-1, size - w[n], w,v, dp);
        return dp[n][size] =  Math.max(take , not);
    }

    public static int tabu(int n, int size, int[] w, int []v){
        int[][] dp = new int[n][size+1];
        for(int i = w[0]; i<= size; i++ ) dp[0][i] = v[0];

        for(int i=1; i<n; i++){
            for(int j = 0; j<= size; j++){
                int not = dp[i-1][j];
                int take = 0;
                if(w[i] <= j) take = v[i] + dp[i-1][j-w[i]];
                dp[i][j] = Math.max(take, not);
            }
        }
        return dp[n-1][size];
    }

    public static int space(int n, int size, int[]w, int[] v){
        int[] prev = new int[size+1];
        for(int i=w[0]; i<= size; i++) prev[i] = v[0];

        for (int i=1; i<n; i++){
            for (int j=size; j >= 0; j--){
                int take = 0;
                if(w[i] <= j) take = v[i] + prev[j-w[i]];
                int not = prev[j];
                prev[j] = Math.max(take, not);
            }
        }
        return prev[size];
    }

}
