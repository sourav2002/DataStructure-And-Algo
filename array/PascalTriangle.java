import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));

        List<List<Integer>> al = generate(n);
        // Printing and display the elements in ArrayList
        for (List<Integer> integers : al) System.out.println(integers + " ");
    }
    // here we are not using simple array because we have to resize the array many times
    private static List<List<Integer>> generate(int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row, previous = null;   // row defines the current list and previous defines the previous list
        for (int i =0; i<n; i++){
            row = new ArrayList<>();
            for (int j=0; j <=i; j++){
                if (j == 0 || j == i){ // make 1st and last value of list/ row equals to One 1
                    row.add(1);
                }else { // else add two values j-1 and j of previous list/row
                    assert previous != null;
                    row.add(previous.get(j-1)+ previous.get(j));
                }
            }
            previous = row;  // save the current row as previous for calculation for next row
            result.add(row);
        }
        return result;
    }
}
