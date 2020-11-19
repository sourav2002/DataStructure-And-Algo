package array;
//Move all negative numbers to beginning and positive to end with constant extra space
//        Examples :
//
//        Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
//        Output: -12 -13 -5 -7 -3 -6 11 6 5

import java.util.Scanner;

public class MoveNegativeNumber {

    static void rearrange(int arr[], int size) {
        int j = 0, temp;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    //print method
    static void printArray(int[] arr) {
        System.out.println("sorted array is: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no. of Test Cases : ");
        int testcases = input.nextInt();

        for (int i = 0; i < testcases; i++) {
            System.out.print("Enter size of array: ");
            int size = input.nextInt();
            int[] arr = new int[size];
            System.out.print("Enter input in array: ");
            for (int j = 0; j < size; j++) {
                int value = input.nextInt();
                int more = size - j - 1;
                if (more > 0) {
                    System.out.print((more) + " more input ");
                }
                arr[j] = value;
            }
            rearrange(arr, size);
            printArray(arr);
            System.out.println();
        }
    }
}
