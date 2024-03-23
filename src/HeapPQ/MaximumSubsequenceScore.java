package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for(int i = 0; i < n; i++) pairs[i] = new int[]{nums1[i], nums2[i]};
        Arrays.sort(pairs, (a, b) -> b[1]-a[1]);

        System.out.println(Arrays.deepToString(pairs));

        long total = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        long ans = 0;
        for(int i = 0; i < n; i++){
            total += pairs[i][0];
            minHeap.add(pairs[i][0]);

            if (i > k - 1) {
                total -= minHeap.poll();
            }

            if(i >= k-1) ans = Math.max(total*pairs[i][1], ans);
        }

        return ans;
    }
}
