import java.util.*;

public class SpiralMatrix {
    public static void spiralOrder(int[][] matrix) {
        // creating of arrayList for answer
        ArrayList<Integer> ans = new ArrayList<Integer>();

        // getting the lengths
        int nRows = matrix.length;
        int mCols = matrix[0].length;
        int count = nRows * mCols;

        // initialization of indices
        int startRow = 0;
        int startCol = 0;
        int endRow = nRows - 1;
        int endCol = mCols - 1;

        // main logic
        while (count > 0) {

            // print starting row
            for (int index = startCol; count > 0 && index <= endCol; index++) {
                ans.add(matrix[startRow][index]);
                count--;
            }
            startRow++;

            // print ending column
            for (int index = startRow; count > 0 && index <= endRow; index++) {
                ans.add(matrix[index][endCol]);
                count--;
            }
            endCol--;

            // print ending row
            for (int index = endCol; count > 0 && index >= startCol; index--) {
                ans.add(matrix[endRow][index]);
                count--;
            }
            endRow--;

            // print starting column
            for (int index = endRow; count > 0 && index >= startRow; index--) {
                ans.add(matrix[index][startCol]);
                count--;
            }
            startCol++;
        }

        // printing value
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        // input matrix
        int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        spiralOrder(mat);
    }
}
