package Stacks;

import java.util.Stack;

public class RmAllAdjacentDuplicatesInString2 {
    static class State{
        char c;
        int freq;

        State(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<State> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.push(new State(s.charAt(i), 1));
                continue;
            }

            if(st.peek().c == s.charAt(i)){
                if(st.peek().freq == k-1){
                    for(int j = 0; j < k-1; j++) st.pop();
                }else st.push(new State(s.charAt(i), st.peek().freq+1));
            }else st.push(new State(s.charAt(i), 1));
        }

        StringBuilder newStr = new StringBuilder();
        while(!st.isEmpty()) newStr.append(st.pop().c);

        return newStr.reverse().toString();
    }
}
