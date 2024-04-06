package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElm1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> monoDesc = new Stack<>();
        HashMap<Integer, Integer> idx = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) idx.put(nums1[i], i);

        for(int i = 0; i < nums2.length; i++){
            while(!monoDesc.isEmpty() && monoDesc.peek() < nums2[i]){
                res[idx.get(monoDesc.pop())] = nums2[i];
            }
            if(idx.get(nums2[i]) != null) monoDesc.push(nums2[i]);
        }

        while(!monoDesc.isEmpty()) res[idx.get(monoDesc.pop())] = -1;

        return res;
    }
}
