package kthdsa.F8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;
    public SingleLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

//    public void remove(E item) {
//        if (head == null) {
//            // Om listan är tom finns inget att ta bort
//            return;
//        }
//
//        if (head.data.equals(item)) {
//            // Om det första elementet är det som ska tas bort
//            head = head.next;
//            size--;
//            return;
//        }
//
//        Node<E> current = head;
//        while (current.next != null) {
//            if (current.next.data.equals(item)) {
//                // Om nästa element är det som ska tas bort
//                current.next = current.next.next;
//                size--;
//                return;
//            }
//            current = current.next;
//        }
//    }

    private Node<E> getNode(int index) {
        return getNodeRecursively(head, index, 0);
    }

    private Node<E> getNodeRecursively(Node<E> currentNode, int targetIndex, int currentIndex) {
        // Base case: Return null if currentNode is null or if the target index is not reached
        if (currentNode == null || currentIndex >= targetIndex) {
            return currentNode;
        }

        // Recursive case: Move to the next node
        return getNodeRecursively(currentNode.next, targetIndex, currentIndex + 1);
    }

    public int getSize(){
        return getSize(head);
    }

    private int getSize(Node<E> node){
        if(node == null) return 0;
        return 1 + getSize(node.next);
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
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
        E removedValue = head.data;
        head = head.next;
        size--;

        return removedValue;
    }

    private E removeAfter(Node<E> node) {
        E removedValue = node.next.data;
        node.next = node.next.next;
        size--;

        return removedValue;
    }

    public Iterator<E> iterator() {
        return new Itr();
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

    private class Itr implements Iterator<E> {
        private Node<E> current;
        private Node<E> prev;        // Pekar på noden innan current
        private Node<E> prevPrev;    // Pekar på noden innan prev
        boolean removeCalled;

        public Itr() {
            current = head;
            prev = null;
            prevPrev = null;
            removeCalled = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E returnValue = current.data;
            prevPrev = prev;
            prev = current;
            current = current.next;
            removeCalled = false;

            return returnValue;
        }

        @Override
        public void remove() {
            if (prev == null || removeCalled) {
                throw new IllegalStateException("remove() cannot be called before next()");
            }

            if (prev == head) {
                // Om vi tar bort det första elementet
                head = current;
            } else {
                // Annars peka över det elementet som tas bort
                prevPrev.next = current;
            }

            size--;
            prev = prevPrev;  // Korrekt hantering av pekare efter remove
            removeCalled = true;
        }
    }
}
