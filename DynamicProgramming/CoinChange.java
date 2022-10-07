import java.util.*;
Class CoinChange{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int amount=sc.nextInt();
        int n=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;i++)coins[i]=sc.nextInt();
        System.out.println("Minimum number of coin change to make up the amount:"+coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for(int i=0;i<=amount;i++)dp[0][i]=Integer.MAX_VALUE - 1;
        for(int i=1;i<=n;i++)dp[i][0]=0;
        for(int i=1,j=1;i<=amount;i++){
            if(i%coins[0]==0)dp[j][i]=i/coins[0];
            else dp[j][i]=Integer.MAX_VALUE - 1;
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }
}
