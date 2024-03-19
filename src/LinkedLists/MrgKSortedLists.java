package LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MrgKSortedLists {

    private static ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        }else if(l2 != null){
            current.next = l2;
        }

        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        while(lists.length > 1){
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i = 0; i < lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = (i+1) < lists.length ? lists[i+1] : null;
                mergedLists.add(mergeLists(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}


//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
//        ListNode newHead = new ListNode(0);
//
//        for(ListNode l : lists){
//            ListNode current = l;
//            while(current != null){
//                pq.add(current.val);
//                current = current.next;
//            }
//        }
//
//        ListNode current = newHead;
//
//        while(!pq.isEmpty()){
//            ListNode newNode = new ListNode(pq.poll());
//            current.next = newNode;
//            current = newNode;
//        }
//
//        return newHead.next;