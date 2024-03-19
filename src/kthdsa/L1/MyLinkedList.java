package kthdsa.L1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        }else if(index == size - 1){
            addToTail(item);
        }else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    //Returnerar null om noden saknas
    private Node<E> getNode(int index) {
        if(index == size-1){
            return tail;
        }
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        if(tail == null) tail = head;
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        if(tail == node) tail = node.next;
        size++;
    }

    private void addToTail(E item){
        Node<E> node = tail;
        tail = new Node<>(item, null);
        node.next = tail;
        size++;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        E removedValue;
        if (index == 0) {
            removedValue = removeFirst();
        } else {
            Node<E> previousNode = getNode(index - 1);
            removedValue = removeAfter(previousNode);
        }

        return removedValue;
    }

    private E removeFirst() {
//        if (head == null) {
//            throw new NoSuchElementException("List is empty");
//        }

        E removedValue = head.data;
        head = head.next;
        if (head == null) {
            // Om listan är nu tom, uppdatera tail
            tail = null;
        }
        size--;

        return removedValue;
    }

    private E removeAfter(Node<E> node) {
//        if (node == tail) {
//            throw new NoSuchElementException("No element after the specified node");
//        }

        E removedValue = node.next.data;
        node.next = node.next.next;
        if (node.next == null) {
            // Om vi tog bort tail, uppdatera tail
            tail = node;
        }
        size--;

        return removedValue;
    }

    public Iterator<E> iterator(){
        return new Itr(head);
    }

    private class Itr implements Iterator<E> {
        Node<E> current;

        public Itr(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
