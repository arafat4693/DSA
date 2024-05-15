package HeapPQ;

import java.util.*;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i = 0; i < profits.length; i++) minHeap.add(new int[]{profits[i], capital[i]});

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < k; i++){
            while(!minHeap.isEmpty() && minHeap.peek()[1] <= w){
                maxProfit.add(minHeap.poll()[0]);
            }
            if(maxProfit.isEmpty()) break;
            w += maxProfit.poll();
        }

        return w;
    }
}
