package LinkedListPackage;
public class ReverseList {
    static Node head = null;
    public static void main(String[] args) {
        add(9);
        add(7);
        add(5);
        add(4);
        add(2);
        add(1);
        print(head);
        Node rev = reverse(head);
        print(rev);

    }

    public static Node reverse(Node head){
        if (head == null && head.next == null){
            return head;
        }
        Node prev = null;
        Node nextNode;
        while (head != null){
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node add(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static class Node{
        private int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
