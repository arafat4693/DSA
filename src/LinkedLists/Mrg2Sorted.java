package LinkedLists;

public class Mrg2Sorted {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode newHead = list1.val <= list2.val ? list1 : list2;
        ListNode nextInSecondList = newHead == list1 ? list2 : list1;
        ListNode current = newHead;

        while(nextInSecondList != null){
            ListNode currentsNext = current.next;
            if(currentsNext != null && currentsNext.val > nextInSecondList.val){
                current.next = nextInSecondList;
                current = nextInSecondList;
                nextInSecondList = currentsNext;
            } else if (currentsNext == null) {
                current.next = nextInSecondList;
                current = nextInSecondList;
                nextInSecondList = null;
            } else{
                current = currentsNext;
            }
        }

        return newHead;
    }
}
