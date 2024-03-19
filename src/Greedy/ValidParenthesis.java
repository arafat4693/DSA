package Greedy;

import java.util.Stack;

public class ValidParenthesis {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') open.push(i);
            else if (s.charAt(i) == '*') star.push(i);
            else{
                if(open.isEmpty() && star.isEmpty()) return false;
                if(open.isEmpty()) star.pop();
                else open.pop();
            }
        }

        while(!open.isEmpty()){
            if(star.isEmpty()) return false;
            if(open.pop() >= star.pop()) return false;
        }

        return true;
    }
}
