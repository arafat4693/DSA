package LinkedLists;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;

        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode[] groups = new ListNode[k];
        curr = head;
        for(int i = 0; i < k; i++){
            int l = (int)Math.ceil((double)length/(k-i)), j = 0;
            ListNode dummy = new ListNode(), root = dummy;
            while(curr != null && j != l){
                root.next = new ListNode(curr.val);
                root = root.next;
                curr = curr.next;
                j++;
            }
            length-=l;
            groups[i] = dummy.next;
        }

        return groups;
    }
}
