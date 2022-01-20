package array;

public class NextLexicographic {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 2};
        nextPermutation(a);
    }

    private static void nextPermutation(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int i = a.length - 2;  // -2 bcz we are checking i with its next index i.e i+1
        // we are using this condition to get the position of i from where
        // we have to make changes for example 13542, i will stop at number 3
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = a.length - 1; // last index
            while (a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1, a.length - 1);
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
