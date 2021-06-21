package SortingAndSearching;

public class SearchAnElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int start = 0;
        int end = arr.length - 1;
        int key = 19;
        searching(arr, start, end, key);
    }
    static void searching(int[] arr, int i, int j, int key) {
        boolean notFound = true;
        int countAttempt = 0;
        try {
            while (notFound) {
                // check what to print  --  i or j by comparing with key value
                countAttempt++;
                if (arr[i] == key) {
                    System.out.println("Element found at Index: " + i);
                    System.out.println("Attempt taken : " + countAttempt);
                    notFound = false;
                } else if (arr[j] == key) {
                    System.out.println("Element found at Index: " + j);
                    System.out.println("Attempt taken : " + countAttempt);
                    notFound = false;
                }
                i = i + 1;
                j = j - 1;
            }
        }catch (Exception e){
            System.out.println("Element not found");
        }
    }
}

