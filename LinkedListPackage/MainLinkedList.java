package LinkedListPackage;

import java.util.*;

public class MainLinkedList {
    public static void main(String[] args){
        MyLinkedList ll = new MyLinkedList();
        ll.add(3);
        ll.add(8);
        ll.add(9);
        ll.add(3);

        ll.print();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.lastIndexOf(2));
        int s = linkedList.size();
//        linkedList.addFirst();
        System.out.println(s);
    }
}
