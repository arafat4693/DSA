package kthdsa.F4;

public class NB9<E> {
    private class Node{
        private E data;
        private Node next;

        private Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public NB9(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(E data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue(){
        if(size == 0) throw new IllegalStateException("Queue is empty!");
        E data = head.data;
        head = head.next;
        if(head == null) tail = null;
        size--;
        return data;
    }

    public int size(){
        return this.size;
    }
}
