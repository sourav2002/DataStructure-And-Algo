package Matrix;

import java.util.ArrayList;
import java.util.List;


/*
Program to generate Pascal’s Triangle
Problem Statement: Given an integer N, return the first N rows of Pascal’s triangle.

In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:
Example 1:

Input Format: N = 5

Result:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.

Approach: To solve the problem, we need to first create an array of size N or numRows (input value).
 This array is used to store each of the rows expected in the output, so, for example, array[1] = [1,1].
 In this array, the number of columns (say, numCols) is equal to the number of the i-th row + 1 (Since, 0-indexed),
 i.e., for 0-th row, numCols = 1. So, the number of columns is different for each row.

Next, we need to run a loop from i = 0 to numRows – 1 (inclusive) in order to store each row in our array.

Set the first and last value of array[i] to 1.
Run another loop from j = 1 to i – 1 (inclusive) and for each iteration put array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));

        List<List<Integer>> al = generate(n);
        // Printing and display the elements in ArrayList
        for (List<Integer> integers : al) System.out.println(integers + " ");
    }

    // here we are not using simple array because we have to resize the array many times
    private static List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row, previous = null;   // row defines the current list and previous defines the previous list
        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // make 1st and last value of list/ row equals to One 1
                    row.add(1);
                } else { // else add two values j-1 and j of previous list/row
                    assert previous != null;
                    row.add(previous.get(j - 1) + previous.get(j));
                }
            }
            previous = row;  // save the current row as previous for calculation of next row
            result.add(row);
        }
        return result;
    }
}

/*
2D list is used to return the result

now create 2 lists one is row(current row ) and another is previous
run 2 for loops
now make 1st and last value of row to 1

now for each iteration put array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
and save the current row as previous for calculation of next row.
 */

