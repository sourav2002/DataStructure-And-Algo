package array;

import java.util.Scanner;

public class MaxAndMin {
    static Pair getMinMax(int arr[], int size) {
        Pair minmax = new Pair();
        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }
        if (size == 1) {
            minmax.min = arr[0];
            minmax.max = arr[1];
        }
        for (int i = 2; i < size; i++) {
            if (arr[i] > minmax.max) {
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min) {
                minmax.min = arr[i];
            }
        }
        return minmax;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = input.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = input.nextInt();
            arr[i] = value;
        }
        Pair minmax = getMinMax(arr, size);
        System.out.println("min is:" + minmax.min);
        System.out.println("max is: " + minmax.max);
    }

    static class Pair {
        int min;
        int max;
    }
}
