package Graphs;

import java.util.*;

public class MinCostToConnectAllPointsPrim {
    public int minCostConnectPoints(int[][] points){
        HashMap<Integer, List<Integer[]>> adj = new HashMap<>();

        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                int cost = (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                adj.putIfAbsent(i, new ArrayList<>());
                adj.putIfAbsent(j, new ArrayList<>());

                adj.get(i).add(new Integer[]{j, cost});
                adj.get(j).add(new Integer[]{i, cost});
            }
        }

        if(adj.isEmpty()) return 0;

        // prim
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new Integer[]{0,0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        int minCost = 0;

        while(visited.size() != points.length){
            Integer[] nCost = minHeap.poll();
            if(visited.contains(nCost[0])) continue;
            visited.add(nCost[0]);
            minCost+=nCost[1];

            for(Integer[] nei : adj.get(nCost[0])){
                if(!visited.contains(nei[0])) minHeap.add(nei);
            }
        }

        return minCost;
    }
}
