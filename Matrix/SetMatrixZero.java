package Matrix;


/*Set Matrix Zero
        Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column
        and row to 0 and then return the matrix.
        Examples:
        Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]
        */


/*

1st of all, we will traverse matrix and update [i] [0] and [0] [j] with 0 if we find any zero in the matrix
according to i and j current values.
special case - check if outer row or col means 0,j or i,0 having a 0 at any index
now traverse the matrix in reverse order to prevent special case
and if we find any 0 at any index then update every index of  row and col with 0
 */

public class SetMatrixZero {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 2, 1}, {3, 0, 5, 2}, {1, 3, 0, 5}, {0, 0, 0, 1}};
        int [][] matrix={{1, 0,0,0}, {3, 0, 5, 2}, {1, 3, 0, 5}, {1,1,1,1}};
//        int [][] matrix={{1, 1, 2, 1}, {3, 1, 5, 2}, {0, 3, 1, 5}, {1,1,1,1}};
        setZeroes(matrix);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j<matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (fr){
            for (int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if (fc){
            for (int i =0; i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
