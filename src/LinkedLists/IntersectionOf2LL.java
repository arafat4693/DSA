package LinkedLists;

public class IntersectionOf2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashSet<ListNode> nodes = new HashSet();

        // ListNode curr = headA;
        // while(curr != null){
        //     nodes.add(curr);
        //     curr = curr.next;
        // }

        // curr = headB;
        // while(curr != null){
        //     if(nodes.contains(curr)) return curr;
        //     curr = curr.next;
        // }

        // return null;

        ListNode curr1 = headA, curr2 = headB;

        int l1 = 0, l2 = 0;

        while(curr1 != null){
            l1++;
            curr1 = curr1.next;
        }

        while(curr2 != null){
            l2++;
            curr2 = curr2.next;
        }

        curr1 = headA;
        curr2 = headB;

        if(l1 > l2){
            while(l1 != l2){
                l1--;
                curr1 = curr1.next;
            }
        }else{
            while(l1 != l2){
                l2--;
                curr2 = curr2.next;
            }
        }

        while(curr1 != null && curr2 != null){
            if(curr1 == curr2) return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;
    }
}
