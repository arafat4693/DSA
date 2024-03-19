package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer[]> st = new Stack<>();
        int largestArea = 0;
        for(int i = 0; i < heights.length; i++){
            int s = i;
            while(!st.empty() && heights[i] < st.peek()[1]){
                Integer[] top = st.pop();
                largestArea = Math.max(largestArea, top[1] * (i-top[0]));
                s = top[0];
            }
            st.push(new Integer[]{s, heights[i]});
        }

        for(Integer[] ints : st){
            largestArea = Math.max(largestArea, ints[1]*(heights.length-ints[0]));
        }

        return largestArea;
    }
}
