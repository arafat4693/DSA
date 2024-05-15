package Strings;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int l = num.length() - k;
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < num.length(); i++){
            int n = (int)num.charAt(i)-'0', r = num.length()-i;
//            while(!st.isEmpty() && st.peek() > n && r+st.size() >= l) st.pop();
            while(!st.isEmpty() && st.peek() > n && k > 0){
                st.pop();
                k--;
            }
            st.push(n);
        }

//        while(st.size() > l) st.pop();
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()) res.insert(0, st.pop());

        while(!res.isEmpty() && res.charAt(0) == '0') res.deleteCharAt(0);

        return res.isEmpty() ? "0" : res.toString();
    }
}
