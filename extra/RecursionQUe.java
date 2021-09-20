package extra;

public class RecursionQUe {
    public static void main(String[] args) {
        String string = "Geeks for geek";
        System.out.println(reverse(string));

        int[] arr = { 2,4,6,8,9,13,15,34};
        printArray(arr,0, arr.length);

        String palindrome = "naman";
        palindrome(palindrome);
    }
    private static void palindrome(String p){
        String check = p;

    }
    private static String  reverse(String string){
        // Base case
        if (string.length() < 2) return string;
        // recursive case
        return reverse(string.substring(1)) + string.charAt(0);
    }
    private static void printArray(int[] arr, int i, int n){
        if (i >= n) {
            return;
        }
        System.out.print(arr[i]+" ");
        printArray(arr,i+1,n);
    }
}
