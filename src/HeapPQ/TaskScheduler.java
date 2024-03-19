package HeapPQ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char t : tasks) hm.put(t, hm.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(char c : hm.keySet()) maxHeap.add(hm.get(c));

        Queue<Integer[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.peek() != null){
                if(maxHeap.peek() - 1 <= 0) maxHeap.poll();
                else q.add(new Integer[]{maxHeap.poll() - 1, time + n});
            }

            if(q.peek() != null && time == q.peek()[1]) maxHeap.add(q.poll()[0]);
        }

        return time;
    }
}
