package kthdsa.F4;

public class NB10<E> {
    private class Node{
        E data;
        Node next;
        Node prev;

        private Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    public E pollFirst(){
        if(empty()) throw new IllegalStateException("Queue is empty");
        E data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }else{
            head.prev = null;
        }
        return data;
    }

    public E pollLast(){
        if(empty()) throw new IllegalStateException("Queue is empty");
        E data = tail.data;
        tail = tail.prev;
        if(tail == null){
            head = null;
        }else{
            tail.next = null;
        }
        return data;
    }

    public void offerFirst(E data){
        Node newNode = new Node(data);
        if(empty()){
            tail = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void offerLast(E data){
        Node newNode = new Node(data);
        if(empty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public boolean empty(){
        return head == null;
    }
}
