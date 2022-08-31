package extra;

import java.util.Scanner;

public class mmt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            int out = solve1(n);
            System.out.println(out);
        }
    }

    public static int solve1(long n){
        int c = 0;
        int arr[] = {1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111 };


        while(n > 0){
            int len = String.valueOf(n).length();
            System.out.println(n +" "+ len);
            if(n < arr[len-1]){
                n  = n - arr[len-2];
                c = c + len-1;
            }else{
                n = n - arr[len-1];
                c = c + len;
            }
        }
        return c;
    }
}
