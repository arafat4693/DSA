package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
//        List<Integer> arr = new ArrayList<>();
//
//        ListNode curr = head;
//        while(curr != null){
//            arr.add(curr.val);
//            curr = curr.next;
//        }
//
//        int tmp = arr.get(k-1);
//        arr.set(k-1, arr.get(arr.size()-k));
//        arr.set(arr.size()-k, tmp);
//
//        ListNode dummy = new ListNode();
//        curr = dummy;
//        for(Integer i : arr){
//            curr.next = new ListNode(i);
//            curr = curr.next;
//        }
//
//        return dummy.next;

//        int size = 0;
//
//        ListNode curr = head;
//        while(curr != null){
//            size++;
//            curr = curr.next;
//        }
//
//        ListNode first = null;
//        ListNode second = null;
//        curr = head;
//        int currIdx = 1;
//
//        while(curr != null){
//            if(currIdx == k){
//                first = curr;
//            }
//            if(currIdx == size-k+1){
//                second = curr;
//                break;
//            }
//
//            curr = curr.next;
//            currIdx++;
//        }
//
//        int tmp = first.val;
//        first.val = second.val;
//        second.val = tmp;
//
//        return head;


        if(head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < k-1; i++) fast = fast.next;

        ListNode tmpFast = fast;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        int tmp = slow.val;
        slow.val = tmpFast.val;
        tmpFast.val = tmp;

        return head;
    }
}
