package LinkedLists;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next, prev = null;
        slow.next = null;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        ListNode firstCurrent = head, secondCurrent = prev;
        while(secondCurrent != null){
            ListNode firstNext = firstCurrent.next, secondNext = secondCurrent.next;
            firstCurrent.next = secondCurrent;
            secondCurrent.next = firstNext;
            firstCurrent = firstNext;
            secondCurrent = secondNext;
        }
    }
}
