package LinkedListPackage;

public class MyLinkedList {

    Node head , tail = null;
    //addNode() will add a node to the list


    // method to add one element
     void add(int data ){
        Node toAdd = new Node(data);

        if(isEmpty()){
            head = toAdd;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = toAdd;
    }

    // method to add on first position
    void  addFirst(int data){
         Node addFirstNode = new Node(data);

    }

    // method to check if list is empty or not
    boolean isEmpty (){
//        if (head == null){
//            return true;
//        }else {
//            return false;
//        }
         return head == null;
    }

    // method to print the array
    void print(){
         Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    // Node to traverse list
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
