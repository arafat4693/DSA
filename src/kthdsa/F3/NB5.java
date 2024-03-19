package kthdsa.F3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class NB5<E> implements StackInt<E>{
    private ArrayList<E> stackList;

    public NB5(){
        this.stackList = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        this.stackList.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) throw new EmptyStackException();
        return stackList.get(this.stackList.size()-1);
    }

    @Override
    public E pop() {
        if(empty()) throw new EmptyStackException();
        return stackList.remove(this.stackList.size()-1);
    }

    @Override
    public boolean empty() {
        return this.stackList.isEmpty();
    }

    @Override
    public String toString() {
        return "NB5{" +
                "stackList=" + stackList +
                '}';
    }
}
