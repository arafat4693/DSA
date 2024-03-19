package LinkedLists;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        ListNode current = head;
//        ListNode prev = null;
//        while(current != null){
//            ListNode next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//
//        return prev;

        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
