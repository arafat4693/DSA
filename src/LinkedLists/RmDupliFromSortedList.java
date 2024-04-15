package LinkedLists;

public class RmDupliFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ) return null;

        ListNode curr = head.next, elm = head;

        while(curr != null){
            if(curr.val != elm.val){
                elm.next = curr;
                elm = curr;
            }
            curr = curr.next;
        }

        elm.next = null;

        return head;
    }
}
