package array;
/*
Implement Pow(x,n) | X raised to the power N
Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).

Examples:

Example 1:

Input: x = 2.00000, n = 10

Output: 1024.00000

Explanation: You need to calculate 2.00000 raised to 10 which gives ans 1024.00000

 */
public class Pow_X_N {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double ans = myPow(x,n);
        System.out.println(ans);
    }

    static double myPow(double x, int n){
        double ans = 1.0;
        long nn = n; //duplicate n(power) because we are going to modify it (nn/2)
        if(nn<0) {   // if the power is negative than make it + by multiplying with -1
            nn = -1 * nn;
        }

        while (nn > 0){
            if (nn % 2  == 1){ //if  the power is odd
                ans = ans * x;
                nn = nn-1;
            }else{ // if the power is even
                x = x * x;
                nn = nn / 2;
            }
        }

        if( n < 0){  // if the power was a negative number
            ans =  1 / ans;
        }
        return ans;
    }
}
