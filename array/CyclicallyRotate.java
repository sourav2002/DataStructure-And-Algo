package array;

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

        List<Integer> newlist = new LinkedList<>(list);
        int lastelement = arr[arr.length-1];
        newlist.add(0,lastelement);
        newlist.remove(arr.length);

        System.out.println(newlist);
    }
}

