package Stacks;

import java.util.Stack;

public class SumOfSubArrMin {
    int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        Stack<int[]> st = new Stack<>(); // [value, length];
        int[] l = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int length = 1;
            while(!st.isEmpty() && st.peek()[0] >= arr[i]) length += st.pop()[1];
            st.push(new int[]{arr[i], length});
            sum += (long) length *arr[i];
            sum %= mod;
            l[i] = length-1;
        }

        // System.out.println(sum);
        // System.out.println(Arrays.toString(l));

        st.clear();

        for(int i = arr.length-1; i >= 0; i--){
            int length = 0;
            while(!st.isEmpty() && st.peek()[0] > arr[i]) length += st.pop()[1];
            st.push(new int[]{arr[i], length+1});
            sum += ((long) length *arr[i] + (long) l[i] *length*arr[i]);
            sum %= mod;
        }

        return (int)sum;
    }
}
