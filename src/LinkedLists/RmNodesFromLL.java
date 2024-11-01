package LinkedLists;

public class RmNodesFromLL {
    public ListNode removeNodes(ListNode head) {
        ListNode rHead = reverseList(head);

        ListNode curr = rHead, dummy = new ListNode(0);
        ListNode biggest = dummy;

        while(curr != null){
            if(curr.val >= biggest.val){
                biggest.next = curr;
                biggest = curr;
            }
            curr = curr.next;
        }

        biggest.next = null;

        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
