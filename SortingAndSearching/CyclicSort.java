import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] a= {5,4,3,2,1};
        sort(a);
            System.out.println(Arrays.toString(a));
    }
    static void sort(int[] arr){
        int i=0;
        while(i<arr.length){//length=4
            int correctIndex=arr[i]-1;
            if(correctIndex>0&& arr[correctIndex]!=arr[i]){
                //Then we swap the numbers till we don't get the number at the correct index
                int temp=arr[correctIndex];
                arr[correctIndex]=arr[i];
                arr[i]=temp;
            }
            else {
                i++;
            }
        }
        }
}
