package HeapPQ;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a ,b) -> a[0] - b[0]);

        for(int i = 0; i < points.length; i++){
            int[] p = points[i];
            pq.add(new Integer[]{p[0]*p[0] + p[1]*p[1], i});
        }

        for(int i = 0; i < k; i++) res[i] = points[pq.poll()[1]];

        return res;
    }
}
