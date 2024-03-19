package Stacks;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!st.empty() && temperatures[st.peek()] < temperatures[i]) result[st.peek()] = i - st.pop();
            if(st.empty() || temperatures[st.peek()] >= temperatures[i]) st.add(i);
        }

        return result;
    }
}
