package Stacks;

import java.util.Stack;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int k = Integer.MIN_VALUE;

        Stack<Integer> st = new Stack<>();

        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] < k) return true;

            while(!st.isEmpty() && st.peek() < nums[i]){
                k = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}
