package DynamicProgramming;

import java.util.*;
public class PalindromicPartitioning{
    static boolean isp(String str,int i,int j){
        while(i<=j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    static int pp(String str,int s,int e,int dp[][]){
        if(s>=e){
            return 0;
        }
        if(dp[s][e]!=-1){
            return dp[s][e];
        }
        if(isp(str,s,e)){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=s;i<=e-1;i++){
            int op1,op2;
            op1 = pp(str,s,i,dp);
            op2 = pp(str,i+1,e,dp);
            res = Math.min(res,(op1+op2+1));
        }
        dp[s][e] = res;
        return res;
    }
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        }
        return pp(str,0,n-1,dp);
    }
    public static void main(String []args){
        String input = "ababbbabbababa";
        System.out.print(palindromicPartition(input));
    }
}