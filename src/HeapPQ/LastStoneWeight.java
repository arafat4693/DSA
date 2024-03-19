package HeapPQ;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int s : stones) pq.add(s);

        while(pq.size() > 1){
            int m1 = pq.poll();
            int m2 = pq.poll();

            if(m1 - m2 != 0) pq.add(m1 - m2);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
