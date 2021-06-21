package array;

public class FIndMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11};
        findNumber(arr);
    }

    private static void findNumber(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != 1) {
                System.out.println(arr[i] + 1);
                break;
            } else if (arr[i + 1] - arr[i] == 1) {
                if (i == arr.length - 2) {
                    System.out.println("Noting is missing");
                    break;
                }
            }
        }
    }
}
