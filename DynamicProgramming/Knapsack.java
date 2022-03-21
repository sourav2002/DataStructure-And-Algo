package DynamicProgramming;

import java.util.Arrays;

/*
Problem : Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total
value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example of 0/1 knapsack problem.
Consider the problem having weights and profits are:
Weights: {3, 4, 6, 5}
Profits: {2, 3, 1, 4}

The weight of the knapsack is 8 kg
The number of items is 4
The above problem can be solved by using the following method:

xi = {1, 0, 0, 1}
= {0, 0, 0, 1}
= {0, 1, 0, 1}

 */
class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
                                  int currentIndex) {

        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // if we have already solved a similar problem, return the result from memory
        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}

/*
public class Knapsack {
    static int[][] dp = new int[100][100];
    static int[] weights;
    static int[] profits;
    static int W;
    public static void main(String[] args) {
        weights = new int[]{3, 4, 6, 5};
        profits = new int[]{2, 3, 1, 4};

        W = 8;

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = func(0,0);
        System.out.println(ans);

    }
    public static int func(int ind, int weight){
        if (weight > W) return Integer.MIN_VALUE;
        if (ind >= profits.length) return 0;

        if (dp[ind][weight] != -1) return dp[ind][weight];
        int steal = profits[ind] + func(ind+1, weight + weights[ind]);
        int notSteal = func(ind+1, weight);
        return dp[ind][weight] =  Math.max(steal, notSteal);
    }
}
*/
