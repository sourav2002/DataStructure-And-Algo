package LinkedListPackage;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList<E>{
    private ListNode<E> last;
    private int length;

    public CircularSinglyLinkedList(){
        this.last= null;
        length=0;
    }

    private static class ListNode<E>{
        private final E data;
        private ListNode<E> next;
        public ListNode(E data){
            this.data = data;
            next = null;
        }
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void createCircularLinkedList(){
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        length = 4;
        last = (ListNode<E>) fourth;
    }

    public void display(){
        if (last ==null){
            return;
        }else{
            ListNode<E> first = last.next;
            while (first != last){
                System.out.print(first.data+"-->");
                first = first.next;
            }
            System.out.println(first.data);
        }
    }

    public void insertFirst(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if (last == null){
            last = newNode;
        }
        else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if (last ==null){
            last = newNode;
            last.next = last;
        }else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else if(last.next == last) {
            last = null;
            length--;
        }
        else {
            last.next = last.next.next;
            length--;
        }
    }

    public void removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else if (last.next == last){
            last = null;
            length--;
        }
        else {
            ListNode<E> previous = last.next;
            while (previous.next != last){
                previous = previous.next;
            }
            previous.next = last.next;
            last = previous;
            length--;
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
//        csll.createCircularLinkedList();
        csll.insertFirst(4);
        csll.insertFirst("ok");
        csll.insertFirst(78);
        csll.insertLast(3);
        csll.insertLast(54);
//        System.out.println(csll.isEmpty());
        csll.display();
        System.out.println("size of list is : "+csll.getLength());
        System.out.println("After removing first: ");
        csll.removeFirst();
        csll.display();
        System.out.println("size of list is : "+csll.getLength());
        System.out.println("After removing last: ");
        csll.removeLast();
        csll.display();
        System.out.println("size of list is : "+csll.getLength());
;
    }
}
