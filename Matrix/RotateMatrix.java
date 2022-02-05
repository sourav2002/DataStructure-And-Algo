package Matrix;

import java.util.Arrays;

/*
Rotate Image by 90 degree
Problem Statement: Given a matrix, your task is to rotate the matrix by 90 degrees.

Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]

Output: [[7,4,1],[8,5,2],[9,6,3]]

Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("original matrix Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // now rotate the matrix
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void rotate(int [][] arr){

        // transpose the matrix
        for (int i=0; i< arr.length; i++){
            for (int j =i; j<arr[0].length; j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }// end of for loop

        // transpose of the matrix means swapping 1st row with 1st column upto nth row with nth column
        /*
        1 2 3       1 4 7
        4 5 6  -->  2 5 8
        7 8 9       3 6 9

        now simply reverse every row
        and we get the desired matrix

        */
        System.out.println("transpose matrix is  :  " + Arrays.deepToString(arr));

        // reverse every row
        // 2 pointer method
        for (int i =0; i< arr.length; i++){
            for (int j=0; j< arr.length/2; j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1 - j]; // last element - 0 , 1 ,2 like this
                arr[i][arr.length-1 - j]  = temp;
            }
        }
    }
}
/*
Approach -
1. transpose the matrix ( change row with column )
2. reverse every row of the matrix
 */