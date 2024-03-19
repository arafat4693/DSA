package LinkedLists;

public class RmvNodeEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode current = head, prev = null;
//        while(current != null){
//            ListNode nextNode = current.next;
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//        }
//
//        int i = 0;
//        current = prev;
//        while(current != null){
//            if (n == 1) {
//                prev = current.next;
//                current.next = null;
//                break;
//            }
//            if(i == n-2 && current.next != null){
//                current.next = current.next.next;
//                break;
//            }
//            current = current.next;
//            i++;
//        }
//
//        current = prev;
//        prev = null;
//        while(current != null){
//            ListNode nextNode = current.next;
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//        }
//
//        return prev;

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = head;

        while(n > 0){
            n--;
            right = right.next;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
