//Given an array arr[] and a number K where K is smaller than size of array,
//        the task is to find the Kth smallest element in the given array.
//        It is given that all array elements are distinct.
package array;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallest {
               // working code
//    // Function to return k'th smallest
//    // element in a given array
//    public static int kthSmallest(Integer[] arr,
//                                  int k)
//    {
//        // Sort the given array
//        Arrays.sort(arr);
//
//        // Return k'th element in
//        // the sorted array
//        return arr[k - 1];
//    }
//
//    // driver program
//    public static void main(String[] args)
//    {
//        Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
//        int k = 2;
//        System.out.print("K'th smallest element is " + kthSmallest(arr, k));
//    }



    public static int minimum(int arr[], int kth){
        Arrays.sort(arr);
        return arr[kth-1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter no. of Test Cases : ");
        int testcases = input.nextInt();
        for (int i = 0; i < testcases; i++) {
            System.out.print("Enter size of array: ");
            int size = input.nextInt();
            int arr[] = new int[size];
            System.out.print("Enter input in array: ");
            for (int j = 0; j < size; j++) {
                int value = input.nextInt();
                int more = size-j-1;
                if (more >0) {
                    System.out.print((more) + " more input ");
                }
                arr[i] = value;
            }
            System.out.println();
            System.out.println("Enter Kth term : ");
             int kth = input.nextInt();
            System.out.println("kth minimum number  is: " + minimum(arr,kth));
        }
    }
}