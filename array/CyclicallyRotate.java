package array;
//Given an array, cyclically rotate the array clockwise by one.
//
//        Examples:
//
//        Input:  arr[] = {1, 2, 3, 4, 5}
//        Output: arr[] = {5, 1, 2, 3, 4}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CyclicallyRotate {
    public static void main (String[] args){
        Integer[] arr = {1, 2, 4, 5, 6, 9 ,3 ,9};

        printRotatedArray(arr);
    }

    private static void printRotatedArray(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);

        List<Integer> newlist = new LinkedList<>();
        newlist.addAll(list);
        int lastelement = arr[arr.length-1];
        newlist.add(0,lastelement);
        newlist.remove(arr.length);

        System.out.println(newlist);
    }
}

