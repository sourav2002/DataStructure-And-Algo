package Matrix;

class CircularMatrix {

    static int MAX = 100;

    static void spiralFill(int m, int n, int a[][]) {
        int val = 1;

        int k = 0, l = 0;
        while (k < m && l < n) {
//          rows */
            for (int i = l; i < n; ++i) {
                a[k][i] = val++;
            }

            k++;

            for (int i = k; i < m; ++i) {
                a[i][n - 1] = val++;
            }
            n--;

            if (k < m) {
                for (int i = n - 1; i >= l; --i) {
                    a[m - 1][i] = val++;
                }
                m--;
            }

            if (l < n) {
                for (int i = m - 1; i >= k; --i) {
                    a[i][l] = val++;
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int m = 4, n = 4;
        int a[][] = new int[MAX][MAX];
        spiralFill(m, n, a);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}