package Stacks;

import java.util.Stack;

class MinStack {
    private Stack<Integer[]> st;

    public MinStack() {
        this.st = new Stack<>();
    }

    public void push(int val) {
        this.st.push(new Integer[]{val, this.st.isEmpty() ? val : Math.min(val, this.getMin())});
    }

    public void pop() {
        this.st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
