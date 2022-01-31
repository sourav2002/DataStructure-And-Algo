package extra;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

public class Arraylist_doubt {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(5);

        System.out.println(al);// list store  null

        int [] arr = new int[5];
        System.out.println(arr[2]); // array store 0

        TreeSet<Integer> t = new TreeSet<>();
        t.add(6);
        t.add(1);
        t.add(6);
        t.add(9);
        t.add(2);

        System.out.println(t);
    }
}
