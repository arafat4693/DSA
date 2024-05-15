package LinkedLists;

public class MaximumTwinSumOfLinkedList {
    public int pairSum(ListNode head) {
        int res = 0;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode curr = head;
        while(curr != null && prev != null){
            res = Math.max(res, curr.val+prev.val);
            curr = curr.next;
            prev = prev.next;
        }

        return res;
    }
}
