package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int l = 0;
        for(int r = 0; r < nums.length; r++){
            while(!dq.isEmpty() && nums[r] > dq.peekLast()){
                dq.pollLast();
            }
            dq.addLast(nums[r]);

            if((r-l+1 == k) && !dq.isEmpty()){
                res[l] = dq.peekFirst();
                if(dq.peekFirst() == nums[l]) dq.pollFirst();
                l++;
            }
        }

        return res;
    }
}
