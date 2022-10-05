package DynamicProgramming;

import java.util.*;
class LongestPalindromicSubstring{
    public static String longestPalindrome(String s) {
        int len = s.length();
        int si=0,ei=len-1;
        boolean dp[][] = new boolean[len][len];
        for(int g=0;g<len;g++){
            for(int i=0,j=g;j<len;i++,j++){
                if(g==0){
                    dp[i][j] = true;
                }else if(g==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j]){
                    si=i;
                    ei=j;
                }
            }
        }
        return s.substring(si,ei+1);
    }
    public static void main (String[] args) {
        System.out.print(longestPalindrome("aba"));
    }
}