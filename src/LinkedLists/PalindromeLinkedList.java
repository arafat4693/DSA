package LinkedLists;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse till mid point
        ListNode curr = slow, prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        curr = head;
        while(curr != null && prev != null){
            if(curr.val != prev.val) return false;
            curr = curr.next;
            prev = prev.next;
        }

        return true;
    }
}
