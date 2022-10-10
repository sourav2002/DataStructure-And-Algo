import java.util.*;
class Main  
{ 
static int getMin(int numArray[], int i, int n) 
{ 
    //return first element if only one element or minimum of the array elements
    return (n == 1) ? numArray[i] : 
        Math.min(numArray[i], getMin(numArray,i + 1 , n - 1)); 
} 
   
public static void main(String[] args)  
{ 
    int numArray[] = { 7,32,64,2,10,23 }; 
    System.out.println("Given Array : " + Arrays.toString(numArray));
    int n = numArray.length; 
    System.out.print("Minimum element of array: " + getMin(numArray, 0, n) + "\n"); 
} 
}
