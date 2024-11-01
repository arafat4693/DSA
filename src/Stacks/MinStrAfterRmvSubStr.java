package Stacks;

import java.util.Stack;

public class MinStrAfterRmvSubStr {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (st.isEmpty()) {
                st.push(curr);
                continue;
            }

            char top = st.peek();

            if (top == 'A' && curr == 'B' || top == 'C' && curr == 'D') {
                st.pop();
            } else
                st.push(curr);
        }

        return st.size();
    }
}
