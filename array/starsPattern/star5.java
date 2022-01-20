package array.starsPattern;

import java.util.Scanner;

public class star5 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int a = n; a > i + 1; a--) {
                System.out.print(" ");
            }
            for (int b = 0; b <= i; b++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
