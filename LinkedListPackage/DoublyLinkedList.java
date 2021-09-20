package LinkedListPackage;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private ListNode<E> head, tail;
    private int length;

    //  constructor of doublyLinkedList class
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    // check if list is empty or not
    public boolean isEmpty(){
        return length ==0; // head ==null
    }

    // to get size of list
    public int size(){
        return length;
    }
    //print list method
    public void printList(){
        ListNode<E> temp = head;
        while(temp != null){
            System.out.print(temp.data+ "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //insert node
    public void insert(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if (isEmpty()){
            head = newNode;
            length++;
        }else {
            tail.next = newNode;
            newNode.previous = tail;
            length++;
        }
        tail = newNode;
    }

    //insert at beginning
    public void insertFirst(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if (isEmpty()){
            tail = newNode;
            length++;
        }else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //insert last
    public void insertLast(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if (isEmpty()){
           head  = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    // insert at given index
    public void insertAtPosition(int position, E data){
        ListNode<E> newNode  = new ListNode<>(data);
        if(position > length+1 || position < 0 ){
            System.out.println("Not possible! operation failed");
        }
        else {
            if (position == length+1){
                tail.next = newNode;
                newNode.next =null;
                tail = newNode;
            }
            else{
                ListNode<E> refNode = head;
                int current_position = 1;
                while(current_position != position ){
                    refNode = refNode.next;
                    current_position++;
                }
                refNode.previous.next  = newNode;
                newNode.next = refNode;
            }
            length++;

        }
    }

    //delete first node
    public void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            if (head == tail){
                tail = null;
            }else{
                head.next.previous = null;
            }
            head = head.next;
            length--;
        }

    }

    //delete last node
    public void removeLast(){
        if (isEmpty()){
            System.out.println("No element in the list");
        }
        tail = tail.previous;
        tail.next = null;
        length--;
    }

//   start of node class
    private static class ListNode<E>{
       private E data;
       private ListNode<E> next;
       private ListNode<E> previous;

        public ListNode(E data){
            this.data = data;
       }
    }// end of node class

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();

//        System.out.println(ll.isEmpty());

//        ListNode<Integer> one = new ListNode<>(1);
//        ListNode<Integer> two = new ListNode<>(2);
//        ListNode<Integer> three = new ListNode<>(3);
//        ListNode<Integer> four = new ListNode<>(4);
//        ListNode<Integer> five = new ListNode<>(5);
//        ll.head = one;
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = null;
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insertFirst(90);
        ll.insertFirst(23);
        ll.insertLast(55);
        ll.insertLast(45);
        ll.printList();
        ll.removeFirst();
        ll.printList();
        ll.removeLast();
        ll.printList();
        ll.insertAtPosition(8, 444);
        ll.printList();
        int length = ll.size();
        System.out.println("size of the list is : "+ length);


    }
}
