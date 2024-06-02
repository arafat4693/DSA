package LinkedLists;

public class Reverse2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), prev = null, curr = dummy, l = null, lp = null;
        int idx = 0;
        dummy.next = head;

        while(idx <= right){
            if(idx == left-1){
                l = curr.next;
                lp = curr;
            }

            if(idx >= left){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }else curr = curr.next;

            idx++;
        }

        l.next = curr;
        lp.next = prev;

        return dummy.next;
    }
}
