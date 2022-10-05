// Linked List class
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSort {

  public static void main(String[] args){
        ListNode head = new ListNode(13);  
        // addition remaining node of the linked list  
        head.next = new ListNode(17);  
        head.next.next = new ListNode(90);  
        head.next.next.next = new ListNode(76);  
        head.next.next.next.next = new ListNode(45);  
        head.next.next.next.next.next = new ListNode(32);  
        head.next.next.next.next.next.next = new ListNode(10);  
        
        head = sortList(head);
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
  }

  // Method to find the middle element.
  public ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
  }
 
  // Method to merge the two linked lists
  public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
  }

  // Method for sorting the linked list and returns the new head
  public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);
  }
}
