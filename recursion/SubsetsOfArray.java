package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArray {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        final ArrayList<Integer> list = new ArrayList<>();

        printSubsets(0, list, arr);
//        System.out.println(ok);
    }

    public static void printSubsets(int i, ArrayList<Integer> list, int[] arr){
        if(i == arr.length) {
            System.out.println(list);
//            ans.add(list);
            return;
        }

        list.add(arr[i]);
        printSubsets(i+1, list,arr);
        list.remove(list.size()-1);
         printSubsets(i+1, list,arr);

    }
}
