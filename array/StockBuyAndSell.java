package array;
/*
Stock Buy And Sell
Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
future to sell that stock. Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.
 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = profit(prices);
        System.out.println("Profit is : "+profit);
    }
    static int profit(int[] arr){
        int n = arr.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            if (arr[i] < minPrice){
                minPrice = arr[i];
            }else if (arr[i] - minPrice > maxProfit){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
