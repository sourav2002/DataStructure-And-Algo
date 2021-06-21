package array;
// Java program to rotate an array by
// d elements

public class RotateArrayByDElements {
    static class RotateArray {
        /*Function to left rotate arr[] of size n by d*/
        void leftRotate(int[] arr) {
            for (int i = 0; i < 2; i++)
                leftRotateByOne(arr);
        }
        static void leftRotateByOne(int[] arr) {
            int i, temp;
            temp = arr[0];
            for (i = 0; i < 7 - 1; i++)
                arr[i] = arr[i + 1];
            arr[arr.length - 1] = temp;
        }

        /* utility function to print an array */
        void printArray(int[] arr) {
            for (int j : arr) System.out.print(j + " ");
        }

        // Driver program to test above functions
        public static void main(String[] args) {
            RotateArray rotate = new RotateArray();
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            rotate.leftRotate(arr);
            rotate.printArray(arr);
        }
    }
}