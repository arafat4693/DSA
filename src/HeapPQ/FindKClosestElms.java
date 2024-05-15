package HeapPQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElms {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)-> {
            if(a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        for(int n : arr){
            maxHeap.add(new int[]{n, Math.abs(x-n)});
            if(maxHeap.size() > k) maxHeap.poll();
        }

        List<Integer> res = new ArrayList<>();

        while(!maxHeap.isEmpty()) res.add(maxHeap.poll()[0]);
        Collections.sort(res);

        return res;
    }
}
