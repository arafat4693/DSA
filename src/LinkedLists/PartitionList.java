package LinkedLists;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(), second = new ListNode(), curr = head;
        ListNode dummyFirst = first, dummySecond = second;

        while(curr != null){
            if(curr.val < x){
                first.next = new ListNode(curr.val);
                first = first.next;
            }else {
                second.next = new ListNode(curr.val);
                second = second.next;
            }

            curr = curr.next;
        }

        first.next = dummySecond.next;
        return dummyFirst.next;
    }
}
