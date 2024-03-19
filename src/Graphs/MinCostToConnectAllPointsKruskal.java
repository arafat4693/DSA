package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostToConnectAllPointsKruskal {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> edges = new ArrayList<>();
        int nrOfUnions = 1;
        int minCost = 0;
        int[] parent = new int[points.length];
        Arrays.fill(parent, -1);

        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                int cost = (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                List<Integer> edge = new ArrayList<>();
                edge.add(i);
                edge.add(j);
                edge.add(cost);

                edges.add(edge);
            }
        }

        edges.sort((a, b) -> a.get(2) - b.get(2));

        for(List<Integer> edge : edges){
            if(nrOfUnions == points.length) return minCost;
            if(union(edge.get(0), edge.get(1), parent)) {
                minCost += edge.get(2);
                nrOfUnions++;
            }
        }

        return minCost;
    }

    private int find(int node, int[] parent){
        int par = parent[node];
        if(par < 0) return node;
        return find(par, parent);
    }

    private boolean union(int u, int v, int[] parent){
        int r1 = find(u, parent), r2 = find(v, parent);
        if(r1 == r2) return false;
        if(parent[r1] < parent[r2]){
            parent[r1] += parent[r2];
            parent[r2] = r1;

            // just for optimization (Not mandatory)
            if(parent[v] != r1) parent[v] = r1;
            if(parent[u] >= 0) parent[u] = r1;
        }else{
            parent[r2] += parent[r1];
            parent[r1] = r2;

            // just for optimization (Not mandatory)
            if(parent[u] != r2) parent[u] = r2;
            if(parent[v] >= 0) parent[v] = r2;
        }
        return true;
    }
}
