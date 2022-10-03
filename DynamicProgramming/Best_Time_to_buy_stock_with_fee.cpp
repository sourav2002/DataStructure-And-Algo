/*
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

*/

class Solution {
public:
    int ans(int index, int buy, vector<int>&prices, int fees,vector<vector<int>> &dp)
    {
        int n = prices.size();
        if(index >= n) return 0;
        if(dp[index][buy] !=-1) return dp[index][buy];
        
        if(buy)
        {
            return dp[index][buy]=  max(-prices[index] + ans(index+1,0,prices,fees,dp), ans(index+1,1,prices,fees,dp));
        }
        
        return dp[index][buy] = max(prices[index]-fees + ans(index+1,1,prices,fees,dp),ans(index+1,0,prices,fees,dp));
        
    }
    
    int maxProfit(vector<int>& prices, int fees) {
        int n = prices.size();
        // vector<vector<int>> dp(n+1,vector<int>(2,0));
        vector<int> next(2,0), cur(2,0);
        
        next[0] = 0;
        next[1] = 0;
        
        for(int index = n-1; index>=0; index--)
        {
            for(int buy=0; buy<=1;buy++)
            {
                if(buy)
                {
                    cur[buy] = max(-prices[index] + next[0] , next[1]);
                }
                else
                {
                    cur[buy] = max(prices[index] - fees + next[1] , next[0]);
                }
            }
            
            next = cur;
        }
        
        return next[1];
    }
};