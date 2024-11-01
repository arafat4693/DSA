package LinkedLists;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        int len = 0;

        ListNode curr = head, prev = null;
        while(curr != null){
            len++;
            prev = curr;
            curr = curr.next;
        }

        k = k%len;
        if(k == 0) return head;

        curr = head;

        for(int i = 0; i < (len - k)-1; i++){
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        prev.next = head;

        return newHead;
    }
}
