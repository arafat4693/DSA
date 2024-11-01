package Stacks;

import java.util.Stack;

public class ValidateStackSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Stack<Integer> st = new Stack<>();

        // int popI = 0;

        // for(int i = 0; i < pushed.length; i++){
        //     if(pushed[i] != popped[popI]) st.push(pushed[i]);
        //     else{
        //         popI++;
        //         while(!st.isEmpty() && st.peek() == popped[popI]){
        //             st.pop();
        //             popI++;
        //         }
        //     }
        // }

        // while(!st.isEmpty()){
        //     if(st.peek() != popped[popI]) return false;
        //     st.pop();
        //     popI++;
        // }

        // return true;

        int j = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            while (!st.isEmpty() && j < popped.length) {
                if (st.peek() == popped[j]) {
                    st.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return st.isEmpty();
    }
}
