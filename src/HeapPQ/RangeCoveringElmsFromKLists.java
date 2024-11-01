package HeapPQ;

import java.util.*;

public class RangeCoveringElmsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            int[] elm = new int[] { nums.get(i).get(0), i, 0 };
            minH.add(elm);
            maxH.add(elm[0]);
        }

        int[] ans = new int[2];
        ans[0] = minH.peek()[0];
        ans[1] = maxH.peek();

        boolean flag = true;

        while (flag) {
            int[] mn = minH.poll();
            int mx = maxH.peek();

            int ansR = ans[1] - ans[0];
            int currR = mx - mn[0];

            if (currR < ansR) {
                ans[0] = mn[0];
                ans[1] = mx;
            }

            int s = nums.get(mn[1]).size();
            if (mn[2] + 1 == s)
                flag = false;
            else {
                int[] elm = new int[] { nums.get(mn[1]).get(mn[2] + 1), mn[1], mn[2] + 1 };
                minH.add(elm);
                maxH.add(elm[0]);
            }
        }

        return ans;
    }
}
