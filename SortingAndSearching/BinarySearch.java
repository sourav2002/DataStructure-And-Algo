package SortingAndSearching;

public class BinarySearch {
    static int attempt = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int x = 4;
        int result = binarySearch(arr, 0, n, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    private static int binarySearch(int[] arr, int l, int r, int x) {
        try {
            if (r >= l) {
                int mid = l + (r - l) / 2;
                attempt++;
                // if the element is present at middle itself
                if (arr[mid] == x) {
                    System.out.println("total attempt taken : " + attempt);
                    return mid;
                }
                // If element is smaller than mid, then
                // it can only be present in left subArray
                else if (x < arr[mid]) {
                    return binarySearch(arr, 0, mid - 1, x);
                }
                // Else the element can only be present
                // in right subarray
                return binarySearch(arr, mid + 1, r, x);
            }
        }catch (Exception e){
            return -1;
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
