package array;
/*
Count inversions in an array
Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array?
Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Example 1:

Input Format: N = 5, array[] = {1,2,3,4,5}

Result: 0

Explanation: we have a sorted array and the sorted array
has 0 inversions as for i < j you will never find a pair
such that A[j] < A[i]. More clear example: 2 has index 1
and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an
inversion.

Example 2:

Input Format: N = 5, array[] = {5,4,3,2,1}

Result: 10

Explanation: we have a reverse sorted array and we will
get the maximum inversions as for i < j we will always
find a pair such that A[j] < A[i].
Example: 5 has index 0 and 3 has index 2 now (5,3) pair
is inversion as 0 < 2 and 5 > 3 which will satisfy out
conditions and for reverse sorted array we will get
maximum inversions and that is (n)*(n-1) / 2.

For above given array there is 4 + 3 + 2 + 1 = 10 inversions.
 */
public class CountInversionsInArray {
    public static void main(String[] args) {
        int [] arr = {5,3,2,4,1};
        int n= arr.length;
        int left =0;
        int right = n-1;
        int[] mergeArr = new int[n];
        int ans = Count(arr,mergeArr,left,right);
        System.out.println("count inversion is : "+ ans);
    }

    static int Count(int[] arr,int[] mergeArr, int left, int right){
        int mid, count = 0;
        if (right > left){
            mid = (left+right)/2;
            count += Count(arr,mergeArr,left,mid);
            count += Count(arr,mergeArr,mid+1, right);

            count += mergeSort(arr,mergeArr,left,mid+1, right);
        }
        return count;
    }

    static int mergeSort(int[] arr, int[] mergeArr, int left, int mid, int right){
        int inv_count=0;
        int i = left;
        int j = mid;
        int index = left;
        while((i <= mid-1) && (j <= right)){
            if(arr[i] <= arr[j]){
                mergeArr[index++] = arr[i++];
            }
            else
            {
                mergeArr[index++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }

        // add rest elements
        while(i <= mid - 1)
            mergeArr[index++] = arr[i++];

        while(j <= right)
            mergeArr[index++] = arr[j++];

        for(i = left ; i <= right ; i++)
            arr[i] = mergeArr[i];

        return inv_count;
    }
}
