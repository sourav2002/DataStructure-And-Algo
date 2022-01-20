package extra;

public class IndexWhereLeftEqualRight {
    public static void main(String[] args) {
        int[] a = {2, 4, 3, 1, 5};

        int sumOFLeft;
        int i = 1;
        int sumOfRight;
        while (i < a.length - 2) {
            sumOFLeft = 0;
            sumOfRight = 0;
            for (int j = i + 1; j <= a.length - 1; j++) {
                sumOfRight += a[j];
            }
            for (int k = i - 1; k >= 0; k--) {
                sumOFLeft += a[k];
            }
            if (sumOFLeft == sumOfRight) {
                System.out.println(i);
                break;
            } else {
                i++;
            }
        }

    }
}
