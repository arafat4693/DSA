package LinkedLists;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(-1, head), curr = head.next, prev = head;

        while(curr != null){
            if(curr.val > prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }

            ListNode tmp = dummy;
            while(curr.val > tmp.next.val) tmp = tmp.next;

            prev.next = curr.next;
            curr.next = tmp.next;
            tmp.next = curr;
            curr = prev.next;
        }

        return dummy.next;
    }
}
