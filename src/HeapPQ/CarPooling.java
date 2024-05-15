package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
//    public boolean carPooling(int[][] trips, int capacity) {
//        Arrays.sort(trips, (a, b) -> a[1]-b[1]);
//
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]); //[dest, index]
//
//        for(int i = 0; i < trips.length; i++){
//            while(!minHeap.isEmpty() && minHeap.peek()[0] <= trips[i][1]){
//                capacity += trips[minHeap.poll()[1]][0];
//            }
//
//            if(capacity < trips[i][0]) return false;
//            capacity -= trips[i][0];
//
//            minHeap.add(new int[]{trips[i][2], i});
//        }
//
//        return true;
//    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        for(int[] trip : trips){
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }

        int sum = 0;

        for(int i = 0; i < 1001; i++){
            sum += arr[i];
            if(sum > capacity) return false;
        }

        return true;
    }
}
