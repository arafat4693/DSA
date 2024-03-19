package Stacks;

import java.util.Stack;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int right, left;

        for(String token : tokens){
            switch (token) {
                case "+" -> {
                    right = st.pop();
                    left = st.pop();
                    st.push(left + right);
                }
                case "-" -> {
                    right = st.pop();
                    left = st.pop();
                    st.push(left - right);
                }
                case "*" -> {
                    right = st.pop();
                    left = st.pop();
                    st.push(left * right);
                }
                case "/" -> {
                    right = st.pop();
                    left = st.pop();
                    st.push(left / right);
                }
                default -> st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
