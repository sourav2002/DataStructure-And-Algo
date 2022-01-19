package Matrix;


/*Set Matrix Zero
        Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column
        and row to 0 and then return the matrix.
        Examples:
        Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]
        */

public class SetMatrixZero {
    public static void main(String[] args) {
        int [][] matrix={{1, 1, 2, 1}, {3, 0, 5, 2}, {1, 3, 0, 5}, {0,0,0,1}};
//        int [][] matrix={{1, 0,0,0}, {3, 0, 5, 2}, {1, 3, 0, 5}, {1,1,1,1}};
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

    private static void setZeroes(int[][] matrix){
        int col0 = 1, row0 = 1, rows = matrix.length, cols = matrix[0].length;
        for (int i =0; i< rows; i++){
            if (matrix[i][0] == 0) col0 = 0;
            for (int j =0; j< cols;j++){
                if (matrix[0][j] == 0) row0 = 0;
                if (col0 != 0) { // do not update index = 0 if col0 = 0
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
        }

        // now traverse the matrix in reverse order
        for (int i = rows -1; i>=0; i--){
            for (int j = cols-1; j>=0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }//end of inner loop
            if (col0 == 0){ // we are doing row or col = 0 separately because initially we ignore it in 1st traversal
                matrix[i][0] = 0;
            }
        }// end of outer loop
    }
}// code is not working for row0 = true , gonna fix it later
