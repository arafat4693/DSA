package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        Stack<String> st = new Stack<>();
        backtracking(0,0,st,output,n);
        return output;
    }

    private void backtracking(int open, int close, Stack<String> st, List<String> output, int n){
        if(open == n && close == n){
            output.add(String.join("", st));
            return;
        }

        if(open < n){
            st.push("(");
            backtracking(open + 1, close, st, output, n);
            st.pop();
        }

        if(close < open){
            st.push(")");
            backtracking(open, close + 1, st, output, n);
            st.pop();
        }
    }
}
