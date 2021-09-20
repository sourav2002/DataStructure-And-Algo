package LinkedListPackage;

public class MyLinkedList<E> {

    private Node<E> head = null;
    private int size = 0; // number of nodes in the list

    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    // method to check if list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // method to add one element
    public void add(E data) {
        Node<E> toAdd = new Node<>(data);
        toAdd.next = null;

        //  CASE 1:  if list is empty then add element on head
        if (isEmpty()) {
            head = toAdd;
            return;
        }

        // CASE 2: if list has already some elements than add at last so for that traverse the list until last element
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = toAdd;
    }

    // method to add on first position
    public void addFirst(E data) {
        if (isEmpty()) {
            Node<E> first = new Node<>(data);
            head = first;
            size++;
        } else {
            Node<E> first = new Node(data);
            first.next = head;
            head = first;
            size++;
        }
    }

    public void deleteByKey(E data) {
        Node<E> currNode = head, prev = null; // we created this prev node just to get the position before the given
        // position for example if the position is 5 than prev will we 4
        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == data) {
            head = currNode.next; // change head
            // Display the message
            System.out.println(data + " found and deleted");
            // Return the updated List
            print();
        }
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != data) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }
        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;   // link previousNode Next with the head of next value of currNode

            // Display the message
            System.out.println(data + " found and deleted");
        }
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(data + " not found");
        }
    }


    public void clearAll() {
        head = null;
        System.out.println("Everything is cleared");
    }

    public void getFirst() {
        System.out.println("First value is " + head.data);
    }

    // method to print the array
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void contains(E find) {
        Node<E> key = head;
    }

    // Node to traverse list
    private static class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            next = prev = null;
        }
    }
}
