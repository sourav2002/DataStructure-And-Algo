package array;

//Write a program to reverse an array or string

//Given an array (or string), the task is to reverse the array/string.
//        Examples :
//
//        Input  : arr[] = {1, 2, 3}
//        Output : arr[] = {3, 2, 1}
//
//        Input :  arr[] = {4, 5, 1, 2}
//        Output : arr[] = {2, 1, 5, 4}

import java.util.Scanner;

public class ReverseTheArray {

    //print method
    static void printArray(int arr[]){
        System.out.println("current array is: ");
        for (int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //reverse method
    static void reverseArray(int arr[], int ith, int jth){
        while (ith < jth){
            int temp;
            temp = arr[ith];
            arr[ith]  = arr[jth];
            arr[jth] = temp;

            ith++;
            jth--;
        }
    }
    // main method
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = input.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = input.nextInt();
            arr[i] = value;
        }
        printArray(arr);
        reverseArray(arr,0,(arr.length-1));
        printArray(arr);

    }

}
