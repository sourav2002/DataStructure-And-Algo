package Matrix;

public class SearchElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int n = 4;
        int x = 27;
        search(arr, n, x);
    }

    private static void search(int[][] arr, int n, int x) {
        int i = 0;
        int j = n - 1; // set index for top right element
        while (i < n && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("Found at " + i + ", " + j);
                return;
            }
            if (arr[i][j] > x) {
                j--;
            } else { // if arr[i][j] < x
                i++;
            }
        }
        System.out.println("Element not found");

    }

}
