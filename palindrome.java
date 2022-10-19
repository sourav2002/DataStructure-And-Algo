public class Palindrome {
    
    public static void main(String[] args) {
        int num = 12321;
        int n = palindrome(num, 0);
        
        if (n == num) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    
    public static int palindrome(int x, int temp) {
        if (x == 0) {
            return temp;
        }
        temp = (temp * 10) + (x % 10);
        
        return palindrome(x / 10, temp);
    }
}
