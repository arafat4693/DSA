package Stacks;

import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> opPar = new Stack<>();
        Stack<Integer> clPar = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') opPar.add(i);
            else if(s.charAt(i) == ')'){
                if(opPar.isEmpty()) clPar.add(i);
                else opPar.pop();
            }
        }

        HashSet<Integer> invalidIdx = new HashSet<>(opPar);
        invalidIdx.addAll(clPar);

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(invalidIdx.contains(i)) continue;
            res.append(s.charAt(i));
        }

        return res.toString();
    }
}
