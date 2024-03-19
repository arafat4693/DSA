package LinkedLists;

public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
//        int size = 0;
//        ListNode current = head;
//        while(current != null){
//            current = current.next;
//            size++;
//        }
//
//        if(size < k || k == 1) return head;
//
//        int processed = 0;
//
//        ListNode dummy = null;
//        ListNode lastTail = null;
//        current = head;
//        while((size - processed) >= k){
//            System.out.println(current.val);
//            ListNode newHead = null;
//            ListNode prev = null;
//            int i = 1;
//            while(i <= k){
//                processed++;
//                ListNode next = current.next;
//                if(i == k && lastTail != null){
//                    lastTail.next = current;
//                    newHead.next = next;
//                    //System.out.println("head: " + newHead.next.val);
//                } else if (i == 1) {
//                    newHead = current;
//                }
//                current.next = prev;
//                prev = current;
//                current = next;
//                i++;
//            }
//            if(processed == k) dummy = prev;
//            lastTail = newHead;
//        }
//        lastTail.next = current;
//        return dummy;


        ListNode dummy = new ListNode(0, head); // abc
        ListNode groupPrev = dummy; // abc -> efg

        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;
            ListNode groupNext = kth.next;

            // reverse
            ListNode prev = groupNext, current = groupPrev.next;
            while(current != groupNext){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            ListNode tmp = groupPrev.next; // head
            groupPrev.next = kth; // 2 (stores new head)
            groupPrev = tmp; // head
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){
        while(curr != null & k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
