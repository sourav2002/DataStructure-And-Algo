package hashing;

//        1) sort the array
//        2) initialized var  i = 0; start = i+1, end = last element
//        3) when i is at 0 check for other 2 values if total sum makes 0 or not
//        4) if total sum is less than 0 then increment start
//        5) if total sum is greater than 0 then decrement end
//        6) do 4th and 5th step till start < end
//        7) if we don't found total sum = 0 then increment i and follow all steps again

import java.util.HashSet;

public class TripletsZeroSum {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplet(arr, n);
    }

    private static boolean findTriplet(int[] arr, int n) {

        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false) {
            System.out.printf(" No Triplet Found\n");
        }
        return found;
    }
}
