package SortingAndSearching;

public class JumpSearch {

    public static int jumpSearch(int arr[], int x) {
        int n = arr.length;
        // Finding block size to be jumped example -> root of length of array
        int step = (int) Math.floor(Math.sqrt(n));
        int prevStep = 0;
        while (arr[step - 1] < x) {
            prevStep = step;
            step = step + step;
            if (prevStep >= n) {
                return -1;
            }
        }
        while (arr[prevStep] < x) {
            prevStep++;
            if (prevStep == Math.min(step, n)) {
                return -1;
            }
            if (arr[prevStep] == x) {
                return prevStep;
            }
        }
        return -1;
    }

    // Driver program to test function
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 2;

        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, x);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);
    }
}
