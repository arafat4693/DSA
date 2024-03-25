package LinkedLists;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // int length = 0;
        // ListNode curr = head;
        // while(curr != null){
        //     length++;
        //     curr = curr.next;
        // }
        // int mid = length/2;
        // int currIdx = 0;
        // curr = head;
        // while(currIdx != mid){
        //     currIdx++;
        //     curr = curr.next;
        // }
        // return curr;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
