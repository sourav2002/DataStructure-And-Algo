package array;

import java.util.Arrays;

public class XOR_Queries_of_Array {

    public static void main(String[] args) {
        int arr[] = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int [] ans = xorQueries(arr,queries);
        System.out.println(Arrays.toString(ans));
    }
    private static int[] xorQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length], q;
        for (int i = 1; i < A.length; ++i){
            A[i] ^= A[i - 1]; // make normal array to a prefix xor array
        }

        for (int i = 0; i < queries.length; ++i) {
            q = queries[i]; // type of q is array
            // acc to que, we have to calculate xor of 2 indexes. So q contains only 0th and 1st index
            res[i] = q[0] > 0 ? A[q[0] - 1] ^ A[q[1]] : A[q[1]]; // q[0] means queries 0th index
            // if q[0] == 0 , return q[1]
        }
        return res;
    }
}
/*
1310. XOR Queries of a SubArray
Medium

You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
Return an array answer where answer[i] is the answer to the ith query.

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8
 */