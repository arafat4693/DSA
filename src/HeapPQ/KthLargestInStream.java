package HeapPQ;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a, b) -> a-b);
        for(int n : nums) add(n);
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
