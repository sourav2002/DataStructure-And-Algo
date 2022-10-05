package DynamicProgramming;

import java.util.*;
public class MaximumLengthofPairChain{
	public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0]=1;
        int omax=1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1] && dp[j]>max){
                    max=dp[j];
                }
            }
            dp[i]=1+max;
            if(dp[i]>omax)omax=dp[i];
        }
        return omax;
    }
    public static void main(String []args){
        int [][] pairs = new int [][]{{1,2},{2,3},{3,4}};
        System.out.print(findLongestChain(pairs));
    }
}