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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public Node getNode(int index) {
        Node curr = head;

        for(int i = 0; i < size; i++){
            if(i == index) return curr;
            curr = curr.next;
        }

        return null;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);

        if(head == null) head = tail = node;
        else {
            node.next = head;
            head = node;
        }

        size++;

        // printList();
    }

    public void addAtTail(int val) {
        Node node = new Node(val);

        if(head == null) head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

        size++;

        // printList();
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;

        if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else{
            Node prev = getNode(index-1);
            Node node = new Node(val);
            Node prevsNext = prev.next;

            prev.next = node;
            node.next = prevsNext;

            size++;

            // printList();
        }

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        if(index == 0){
            head = head.next;
            if(head == null) tail = null;
        }
        else{
            Node prev = getNode(index-1);

            if(index == size-1) {
                prev.next = null;
                tail = prev;
            }else{
                Node next = prev.next.next;
                prev.next = next;
            }
        }

        size--;

        // printList();
    }

    private void printList(){
        StringBuilder list = new StringBuilder();

        Node curr = head;

        for(int i = 0; i < size; i++){
            list.append(curr.val);
            if(i != size-1) list.append("-->");
            curr = curr.next;
        }

        System.out.println(list);
    }
}
