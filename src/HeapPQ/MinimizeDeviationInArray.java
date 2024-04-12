package HeapPQ;

import java.awt.*;
import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((a, b) -> a.x - b.x);
        int maxElm = 0;

        for(int n : nums){
            int tmp = n;
            while(n % 2 == 0) n /= 2;
            minHeap.add(new Point(n, Math.max(n*2, tmp)));
            maxElm = Math.max(n, maxElm);
        }

        int res = Integer.MAX_VALUE;

        while(minHeap.size() == nums.length){
            Point top = minHeap.poll();
            res = Math.min(res, maxElm-top.x);

            if(top.x < top.y){
                minHeap.add(new Point(top.x*2, top.y));
                maxElm = Math.max(maxElm, top.x*2);
            }
        }

        return res;
    }
}
