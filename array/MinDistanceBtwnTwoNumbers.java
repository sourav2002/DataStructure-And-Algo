package array;

public class MinDistanceBtwnTwoNumbers {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 3, 1, 5, 8, 9, 4, 1, 9, 0, 6, 3, 11, 14};
        int num1 = 3, num2 = 9;
        findDistance(arr, num1, num2);

    }

    private static void findDistance(int[] arr, int num1, int num2) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                count = count + 1;
            }
            if (arr[i] == num2) {
                break;
            }
            System.out.println(count);
        }
    }
}
