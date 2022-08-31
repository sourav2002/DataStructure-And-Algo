package extra;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int num = sc.nextInt();
            String out = sovle(num);
            System.out.println(out);
        }
    }

    public static String sovle(int n){
        long min = 1;
        long max = 9;
        for(long i=2; i<=n; i++){
            min = min * 10;
            max = (max * 10) + 9;
        }

        while(min % 7 != 0){
            min++;
        }
        for(long i = min; i<= max; i+=7){
            if(isPalindrome(i) == 1 && i%7 == 0){
                return String.valueOf(i);
            }
        }
        return "";
    }

    static long isPalindrome(long n) {
        long rev = 0;
        for (long i = n; i > 0; i /= 10){
            rev = rev * 10 + i % 10;
        }
        return(n == rev) ? 1 : 0;
    }

}
