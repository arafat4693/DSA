package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {
    int mod = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] mix = new int[n][2];
        for(int i = 0; i < n; i++) mix[i] = new int[]{speed[i], efficiency[i]};

        Arrays.sort(mix, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        long total = 0, res = 0;
        for(int i = 0; i < n; i++){
            if(minHeap.size() == k) total -= minHeap.poll();

            int s = mix[i][0], e = mix[i][1];

            total += s;
            minHeap.add(s);
            res = Math.max(res, total * e);
        }

        return (int)(res%mod);
    }
}
