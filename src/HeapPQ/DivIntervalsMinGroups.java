package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivIntervalsMinGroups {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int[] val : intervals) {
            int start = val[0];
            int end = val[1];

            if (pq.isEmpty() || pq.peek() >= start)
                pq.add(end);
            else {
                pq.poll();
                pq.add(end);
            }
        }

        return pq.size();
    }
}
