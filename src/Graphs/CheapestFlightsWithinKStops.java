package Graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Integer[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int[] flight : flights) adj.get(flight[0]).add(new Integer[]{flight[1], flight[2]});

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new Integer[]{src, 0, -1});
        HashMap<Integer, Integer> visited = new HashMap<>();

        int minWeight = Integer.MAX_VALUE;

        while(!minHeap.isEmpty()){
            Integer[] top = minHeap.poll();

            System.out.println(Arrays.toString(top));

//            if(top[0] == dst) minWeight = Math.min(minWeight, top[1]);
            if(top[0] == dst){
                minWeight = Math.min(minWeight, top[1]);
                visited.put(top[0], minWeight);
                continue;
            }
            if(top[2] >= k || (visited.get(top[0]) != null && visited.get(top[0]) <= top[1])) continue;
            visited.put(top[0], Math.min(visited.getOrDefault(top[0], Integer.MAX_VALUE), top[1]));

            for(Integer[] nei : adj.get(top[0])){
                if(visited.containsKey(nei[0])){
                    if(visited.get(nei[0]) > nei[1]+top[1]) minHeap.add(new Integer[]{nei[0], nei[1]+top[1], top[2]+1});
                } else minHeap.add(new Integer[]{nei[0], nei[1]+top[1], top[2]+1});
            }
        }

        return minWeight == Integer.MAX_VALUE ? -1 : minWeight;
    }

    public int findCheapestPrices(int n, int[][] flights, int src, int dst, int k){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int[] tmp = Arrays.copyOf(dist, n);

        for(int i = 0; i <= k; i++){

            for(int[] flight : flights){
                int flightSrc = flight[0];
                int flightDst = flight[1];
                int flightPrice = flight[2];

                if(dist[flightSrc] == Integer.MAX_VALUE) continue;
                tmp[flightDst] = Math.min(dist[flightSrc] + flightPrice, tmp[flightDst]);
            }

            dist = Arrays.copyOf(tmp, n);
//            System.out.println(Arrays.toString(dist));
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
