package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinFuelCostToReportCapital {
    long fuels = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i <= roads.length; i++) adj.putIfAbsent(i, new ArrayList<>());

        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        dfs(0, -1, seats, adj);

        return fuels;
    }

    private int dfs(int node, int parent, int seats, HashMap<Integer, List<Integer>> adj){
        int passenger = 0;
        for(Integer nei : adj.get(node)){
            if(nei != parent){
                int p = dfs(nei, node, seats, adj);
                fuels += (long) Math.ceil((double)p/seats);
                passenger += p;
            }
        }
        return passenger + 1;
    }
}
