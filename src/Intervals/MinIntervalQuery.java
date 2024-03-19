package Intervals;

import java.util.*;

public class MinIntervalQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Queue<Integer>> qMap = new HashMap<>();
        for(int q = 0; q < queries.length; q++){
            qMap.putIfAbsent(queries[q], new LinkedList<>());
            Queue<Integer> queue = qMap.get(queries[q]);
            queue.add(q);
            qMap.put(queries[q], queue);
        }

        Arrays.sort(queries);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[0] - b[0] == 0) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] output = new int[queries.length];

        int j = 0;
        for(int i = 0; i < queries.length; i++){
            while(j < intervals.length){
                if(intervals[j][0] > queries[i]) break;
                minHeap.add(new int[]{ intervals[j][1] - intervals[j][0] + 1, intervals[j][1] });
                j++;
            }

            while(!minHeap.isEmpty()){
                if(minHeap.peek()[1] < queries[i]) minHeap.poll();
                else break;
            }

            if(minHeap.isEmpty()) output[qMap.get(queries[i]).poll()] = -1;
            else output[qMap.get(queries[i]).poll()] = minHeap.peek()[0];
        }

        return output;
    }
}
