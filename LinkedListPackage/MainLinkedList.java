package LinkedListPackage;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(3);
        ll.add(8);
        ll.add(6);
        ll.add(13);
        ll.addFirst(9);
        ll.addFirst(2);
        ll.deleteByKey(6);

        ll.print();
        ll.getFirst();
        ll.contains(8);

        ll.clearAll();
        ll.add(5);
        ll.print();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        System.out.println(linkedList.getLast());
//        System.out.println(linkedList.lastIndexOf(2));
//        int s = linkedList.size();
////        linkedList.addFirst();
//        System.out.println(s);
    }
}
