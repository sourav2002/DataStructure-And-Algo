package DynamicProgramming;

public class LongestCommonSubSequence {


    public static int recursivelcs(int i, int j, String s1, String s2) {
        //base case
        // if i and j reaches the length of string or ArrayIndexOutOFBound
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        //if both are same
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + recursivelcs(i + 1, j + 1, s1, s2); // if 2 alphabets matches than move to next alphabet so i+1, j+1
        } else {// if both are not same
            int left = recursivelcs(i + 1, j, s1, s2);   // first only increment i by 1;
            int right = recursivelcs(i, j + 1, s1, s2); // then increment j by 2
            return Math.max(left, right);
        }
    }

    // Dynamic programming
    // i and j two parameters are changing, so we need 2d matrix (m x n) for memoization
    public static int lcs(int i, int j, String s1, String s2, int[][] memo ) {

        //base case
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        // if the state has been visited previously
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {  // if char match
            return 1 + lcs(i + 1, j + 1, s1, s2, memo);
        }
        else {  // if both are not same
            int left = lcs(i + 1, j, s1, s2, memo);
            int right = lcs(i, j + 1, s1, s2, memo);
            return memo[i][j] = Math.max(left,right);
        }
    }

    public static void main(String[] args) {
        String s1 = "AGGTABslhsghad";
        String s2 = "GXTXAYBdnksghad";

        int n = s1.length();
        int m = s2.length();

        int[][] memo = new int[1000][1000];
        for(int i = 0; i < 1000; i++)
        {
            for(int j = 0; j < 1000; j++)
            {
                memo[i][j] = -1;
            }
        }
        long start = System.currentTimeMillis();
        System.out.println("Longest common subsequence is "+lcs(0,0, s1,s2,memo));
        long end = System.currentTimeMillis();
        System.out.println("time taken by dp - "+ (end - start)+"ms");

        System.out.println("\n");
//   using recursion
        long recSt = System.currentTimeMillis();
        System.out.println("Longest common subsequence with recursion only is "+recursivelcs(0, 0, s1, s2));
        long recEnd = System.currentTimeMillis();
        System.out.println("Time taken by recursive function is - "+ (recEnd - recSt)+"ms");

    }
}
