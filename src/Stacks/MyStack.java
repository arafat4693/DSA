package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> st;

    public MyStack() {
        st = new LinkedList<>();
    }

    public void push(int x) {
        st.add(x);
        int size = st.size()-1;
        while(size > 0){
            st.add(pop());
            size--;
        }
    }

    public int pop() {
        return st.poll();
    }

    public int top() {
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}
