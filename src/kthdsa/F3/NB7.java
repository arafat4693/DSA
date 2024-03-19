package kthdsa.F3;

import java.util.EmptyStackException;

public class NB7<E> implements StackInt<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;
    public NB7()
    {
        top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public int size(){
        int stackSize = 0;
        Node<E> current = this.top;
        while(current != null){
            stackSize++;
            current = current.next;
        }
        return stackSize;
    }

    public E peek(int n){
        if(n < 0 || n >= size()) throw new ArrayIndexOutOfBoundsException();
        Node<E> current = this.top;
        for (int i = 0; i < n; i++) {
            if (current == null) {
                throw new EmptyStackException();
            }
            current = current.next;
        }
        return current.data;
    }

    public E flush(){
        if(empty()) throw new EmptyStackException();
        E result = top.data;
        this.top = null;
        return result;
    }
}
