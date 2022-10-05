package array.basic;
import java.util.*;

public class ArrayListImplement {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("apple");
        fruits.add("mango");
        System.out.println(fruits);

        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(1);
        marks.add(3);

        Pair<Integer, String> p = new Pair<>(5,"sourav");
        Pair<String , Integer> p1 = new Pair<>("Aman", 5);
        p.getDescription();
        p1.getDescription();
    }
}
