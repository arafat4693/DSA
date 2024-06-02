package LinkedLists;

public class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        Node head = null;
        Node tail = null;
        size = 0;
    }

    public int get(int index) {
        // System.out.println(size);
        if(index < 0 || index >= size) return -1;
        if(size == 1) return head.val;
        if(index == size-1) return tail.val;

        Node curr = head;
        for(int i = 0; i < size; i++){
            if(i == index) break;
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        if(size == 0) head = tail = newHead;
        else head = newHead;
        size++;
        // System.out.println("head: " + size);
    }

    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if(size == 0) head = tail = newTail;
        else{
            tail.next = newTail;
            tail = newTail;
        }
        size++;
        // System.out.println("tail: " + size);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else{
            Node prev = head, curr = head.next;
            for(int i = 1; i < size; i++){
                if(i == index) break;
                prev = curr;
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.next = curr;
            prev.next = newNode;
            size++;
        }
        // System.out.println("idx: " + size);
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        if(index == 0) head = head.next;
        else {
            Node prev = head, curr = head.next;
            for(int i = 1; i < size; i++){
                if(i == index) break;
                prev = curr;
                curr = curr.next;
            }
            System.out.println("p: " + prev.val);
            System.out.println("t: " + tail.val);
            System.out.println("c: " + curr);
            prev.next = curr.next;
            // curr.next = null;
        }
        size--;
    }
}
