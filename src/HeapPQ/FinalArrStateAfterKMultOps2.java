package HeapPQ;

import java.util.PriorityQueue;

public class FinalArrStateAfterKMultOps2 {
    int mod = 1000000007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int mx = 0, n = nums.length;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for(int i = 0; i < nums.length; i++) {
            pq.add(new long[]{(long)nums[i], (long)i});
            mx = Math.max(nums[i], mx);
        }

        while(k > 0 && pq.peek()[0] <= mx) {
            long[] top = pq.poll();
            top[0] *= multiplier;
            pq.add(top);
            k--;
        }

        int full = k / n, rem = k % n;
        long val = (long)(Math.pow(multiplier, full));

        while(!pq.isEmpty()) {
            long[] top = pq.poll();
            long elm = top[0], idx = top[1];

            System.out.println(elm);

            elm = ((elm%mod)*val)%mod;
            if(rem > 0) {
                rem--;
                elm = (elm * multiplier) % mod;
            }

            System.out.println(elm);

            nums[(int)idx] = (int)(elm);
        }

        return nums;
    }
}
