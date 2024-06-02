package Graphs;

import java.util.*;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<double[]>> adj = new HashMap<>(); //List: [val, prob]
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            adj.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }

        PriorityQueue<double[]> q = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));
        q.add(new double[]{start_node, 1});
        HashSet<Double> visited = new HashSet<>();

        while(!q.isEmpty()){
            double[] top = q.poll();

            if((int)top[0] == end_node) return top[1];
            if(visited.contains(top[0])) continue;
            visited.add(top[0]);

            for(double[] nei : adj.get((int)top[0])){
                if(visited.contains(nei[0])) continue;
                q.add(new double[]{nei[0], nei[1] * top[1]});
            }
        }

        return 0;
    }
}
