package DynamicProgramming;

// in dynamic programming, we store value into an array so that if that small problem occurs again than we simply
// use solution of that sub problem to solve big problem

public class FibonacciNumberUsingBottomUpApproach {


    public int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int x = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        return x;
    }


    public int fibo(int number) {
        // using table array to store ans of sub problem
        int[] table = new int[number + 1];// we are taking n+1 because we start from 0 so for 5th number, array should be of size 6
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= number; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[number];
    }

    public static void main(String[] args) {
        FibonacciNumberUsingBottomUpApproach obj = new FibonacciNumberUsingBottomUpApproach();
        long start = System.currentTimeMillis();
        System.out.println("The 42th fibonacci number is - " + obj.fibo(42));
        long end = System.currentTimeMillis();
        System.out.println("Time taken to run dynamic programme is " + (end - start) + "ms");

        long recStart = System.currentTimeMillis();
        obj.recursiveFibonacci(42);
        long recEnd = System.currentTimeMillis();
        System.out.println("Time taken to run recursive programme is " + (recEnd - recStart) + "ms");
    }
}// this solution is optimized than a recursive solution for fibonacci series
