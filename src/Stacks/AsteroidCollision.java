package Stacks;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){
            while(!st.isEmpty() && a < 0 && st.peek() > 0){
                int diff = a + st.peek();
                if(diff < 0){
                    st.pop();
                }else if(diff > 0){
                    a = 0;
                }else {
                    a = 0;
                    st.pop();
                }
            }

            if(a != 0) st.add(a);
        }

        int[] res = new int[st.size()];

        int i = st.size()-1;
        while(!st.isEmpty()){
            res[i--] = st.pop();
        }

        return res;
    }
}
