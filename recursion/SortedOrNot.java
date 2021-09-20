package recursion;

public class SortedOrNot {
    public static boolean sorted(int arr[],int index){
        if (index == arr.length-1){
            return true;
        }
        if (arr[index] < arr[index+1]){
            return sorted(arr,index+1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,9};
        System.out.println(sorted(arr,0));
    }
}
