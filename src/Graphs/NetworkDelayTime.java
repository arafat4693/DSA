package Graphs;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Integer[]>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new Integer[]{k, 0});

        int minTime = 0;

        for(int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());

        for(int[] time : times){
            adj.get(time[0]).add(new Integer[]{time[1], time[2]});
        }

        while(!minHeap.isEmpty()){
            Integer[] top = minHeap.poll();
            if(visited.contains(top[0])) continue;
            visited.add(top[0]);
            minTime = Math.max(minTime, top[1]);

            for(Integer[] nei : adj.get(top[0])){
                if(!visited.contains(nei[0])) minHeap.add(new Integer[]{nei[0], nei[1]+top[1]});
            }
        }

        return visited.size() != n ? -1 : minTime;
    }
}
