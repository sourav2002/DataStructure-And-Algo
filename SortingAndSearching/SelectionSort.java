package SortingAndSearching;

import java.util.Scanner;


public class SelectionSort {

    // sort method
    public static void sort(int[] arr, int size) {
        for (int a = 0; a < size - 1; a++) {
            int minIndex = a;
            for (int b = a + 1; b < size; b++) {
                // check if current index element is less then minimum index element
                if (arr[b] < arr[minIndex]) {
                    minIndex = b;
                }
            }
            int temp;
            if (a != minIndex) {
                temp = arr[a];
                arr[a] = arr[minIndex];
                arr[minIndex] = temp;
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
            sort(arr, size);
            printArray(arr);
            System.out.println();
        }
    }
}