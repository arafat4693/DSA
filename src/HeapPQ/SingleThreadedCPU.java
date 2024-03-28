package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];

        PriorityQueue<int[]> enq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });

        for(int task = 0; task < tasks.length; task++) enq.add(new int[]{task, tasks[task][0], tasks[task][1]});

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2]) return a[0] - b[0];
            return a[2] - b[2];
        });

        int idx = 0, time = 0;

        while(!minHeap.isEmpty() || !enq.isEmpty()){
            if(minHeap.isEmpty()){
                int[] nextTask = enq.poll();
                time = nextTask[1];
                minHeap.add(nextTask);
            }

            int[] task = minHeap.poll();
            res[idx++] = task[0];
            time += task[2];

            while(!enq.isEmpty()){
                int[] available = enq.peek();
                if(available[1] > time) break;
                minHeap.add(enq.poll());
            }
        }

        return res;
    }
}
