package ArrayAndHashing;

import java.util.*;

public class FreqStack {
    HashMap<Integer, Stack<Integer>> stack;
    HashMap<Integer, Integer> freq;
    int maxGroup;
    public FreqStack() {
        freq = new HashMap<>();
        stack = new HashMap<>();
        maxGroup = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);
        int count = freq.get(val);

        stack.putIfAbsent(count, new Stack<>());
        stack.get(count).add(val);
        maxGroup = Math.max(count, maxGroup);
    }

    public int pop() {
        Stack<Integer> group = stack.get(maxGroup);
        int val = group.pop();

        freq.put(val, freq.get(val)-1);

        if(group.isEmpty()) stack.remove(maxGroup--);
        if(freq.get(val) == 0) freq.remove(val);

        return val;
    }
}
