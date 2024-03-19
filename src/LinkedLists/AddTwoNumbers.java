package LinkedLists;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        ListNode l3 = new ListNode(0);
        ListNode currentl3 = l3;

        int rest = 0;

        while(currentL1 != null || currentL2 != null){
            int sum = (currentL1 == null ? 0 : currentL1.val) + (currentL2 == null ? 0 : currentL2.val);
            ListNode newNode = new ListNode((sum+rest)%10);
            currentl3.next = newNode;
            currentl3 = newNode;

            currentL1 = currentL1 == null ? null : currentL1.next;
            currentL2 = currentL2 == null ? null : currentL2.next;

            if(sum+rest > 9){
                rest = (sum+rest) / 10;
            }else rest = 0;
        }

        if(rest != 0) currentl3.next = new ListNode(rest);

        return l3.next;
    }
}
