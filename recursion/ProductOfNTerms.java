import java.util.*;

class Prod{
    public static int help(int n){
        if(n == 1)return n;
        return n * help(n - 1);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Product of "+n+" terms: "+help(n));
    } 
}
