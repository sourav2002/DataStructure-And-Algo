package DynamicProgramming;

import java.util.Scanner;

public class FibonacciUsingTopDown {
    public int fibonacci(int[] memo, int n){

        if (memo[n] == 0){ // checking if we had already solved this problem or not
            if (n < 2){
                memo[n] = n; // for 0 and 1
            }else {
                int left = fibonacci(memo, n-1);
                int right = fibonacci(memo, n-2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciUsingTopDown fibo = new FibonacciUsingTopDown();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number : ");
        int n = sc.nextInt();
        sc.close();
        long start = System.currentTimeMillis();
        System.out.println("The "+ n+ "th number is " + fibo.fibonacci(new int[n+1], n));
        long end = System.currentTimeMillis();
        System.out.println("time taken by top down approach is "+ (end- start)+"ms");
    }
}
