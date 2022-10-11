import java.util.*;
public class Reversearray {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the Size  of array :  ");
       int size = sc.nextInt();
       int numbers[] = new int[size];
 
       for(int i=0; i<size; i++) {
           numbers[i] = sc.nextInt();
       }
 
       //print the numbers in array
    //    
       for(int i=size-1; i>=0; i--) {
           System.out.print(numbers[i]+" ");
       }
   }
}
