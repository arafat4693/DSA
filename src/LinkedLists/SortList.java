package LinkedLists;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode slowNext = slow.next;
        slow.next = null;

        ListNode a = sortList(head);
        ListNode b = sortList(slowNext);
        ListNode c = new ListNode();

        merge(a, b, c);
        return c.next;
    }

    private void merge(ListNode a, ListNode b, ListNode c){
        while(a != null && b != null){
            if(a.val < b.val){
                c.next = a;
                a = a.next;
            }else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }

        if(a != null) c.next = a;
        if(b != null) c.next = b;
    }
}
