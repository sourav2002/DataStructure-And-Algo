package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfTwoArray {
    static void printUnion(Integer[] arr1, Integer[] arr2) {

        List<Integer> firstList = Arrays.asList(arr1);
        List<Integer> secondList = Arrays.asList(arr2);

        Set<Integer> set = new HashSet<>();
        set.addAll(firstList);
        set.addAll(secondList);

        Integer[] union = {};
        union = set.toArray(union);

        System.out.println("union array : ");
        System.out.println(Arrays.toString(union));
    }
        // main method
        public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 4, 5, 6};
        Integer[] arr2 = {2, 3, 5, 7, 9};

        printUnion(arr1, arr2);
    }
}
