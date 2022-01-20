package array.starsPattern;

import java.util.Scanner;

public class star4 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {        // O(n)

            for (int j = n; j > i + 1; j--) {          // O(n)
                System.out.print(" ");
            }                             //    +

            for (int a = 0; a <= i; a++) {       // O(n)
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // time complexity - 2(n^2)
}
