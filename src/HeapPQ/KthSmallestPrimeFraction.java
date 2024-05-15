package HeapPQ;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    class State{
        double frac;
        int i;
        int j;
        State(double frac, int i, int j){
            this.frac = frac;
            this.i = i;
            this.j = j;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            if(a.frac < b.frac) return -1;
            return 1;
        });
        for(int i = 0; i < arr.length; i++) pq.add(new State((double)arr[i]/arr[arr.length-1], i, arr.length-1));

        int smallest = 1;
        while(smallest < k){
            State s = pq.poll();
            pq.add(new State((double)arr[s.i]/arr[s.j-1], s.i, s.j-1));
            smallest++;
        }

        return new int[]{arr[pq.peek().i], arr[pq.poll().j]};
    }
}
