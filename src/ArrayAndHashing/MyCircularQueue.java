package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    static class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        head = tail = null;
        this.size = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if(size == capacity) return false;
        size++;
        if(head == null) head = tail = new Node(value);
        else{
            Node newHead = new Node(value);
            newHead.next = head;
            newHead.prev = null;

            head.prev = newHead;
            head = newHead;
        }
        return true;
    }

    public boolean deQueue() {
        if(size == 0) return false;
        if(size == 1) head = tail = null;
        else{
            Node newTail = tail.prev;
            tail.prev = null;
            newTail.next = null;
            tail = newTail;
        }
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : tail.val;
    }

    public int Rear() {
        return size == 0 ? -1 : head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
