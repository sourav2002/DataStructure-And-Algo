// leetcode 24. Swap Nodes in Pairs solution
public class Swap {
    
    public ListNode swapPairs(ListNode head) {
        ListNode dummy= new ListNode(0);
        ListNode curr=head, prev=dummy;
        dummy.next=head;
        while(curr!=null && curr.next!=null){
            prev.next=curr.next;
            curr.next=curr.next.next;
            prev.next.next=curr;
            curr=curr.next;
            prev=prev.next.next;
        }
        return dummy.next;
    }
    
}
