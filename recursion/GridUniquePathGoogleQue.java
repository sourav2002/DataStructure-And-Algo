package recursion;

import java.util.Arrays;

public class GridUniquePathGoogleQue {
    public static void main(String[] args) {
        int[][] path = {{1, 2, 3}, {3, 4, 8}};
        Arrays.stream(path).map(Arrays::toString)
                .forEach(System.out::println);
        int ans = countPath(0, 0, path.length, path[0].length);
        System.out.println(ans);
    }

    private static int countPath(int i, int j, int n, int m) {
        if (i == (n - 1) && j == (m - 1)) return 1;
        if (i >= n || j >= m) return 0;
        else return countPath(i + 1, j, n, m) + countPath(i, j + 1, n, m); // using recursion   f
    }

}
