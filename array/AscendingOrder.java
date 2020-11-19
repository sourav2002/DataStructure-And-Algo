package array;
//Given an array of size N containing 0s, 1s, and 2s; sort the array in ascending order.

import java.util.Scanner;

public class AscendingOrder {

    static void sort(int arr[], int size) {
        for (int i = 0; i < size-1; i++) {
            boolean sorted = true;

            for (int j = 0; j < size-1-i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    sorted= false;
                }
            }
            if (sorted) break;
        }
    }

    //print method
    static void printArray(int arr[]) {
        System.out.println("sorted array is: ");
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
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
            int arr[] = new int[size];
            System.out.print("Enter input in array: ");
            for (int j = 0; j < size; j++) {
                int value = input.nextInt();
                int more = size - j - 1;
                if (more > 0) {
                    System.out.print((more) + " more input ");
                }
                arr[j] = value;
            }
            sort(arr, size);
            printArray(arr);
            System.out.println();
        }
    }
}
