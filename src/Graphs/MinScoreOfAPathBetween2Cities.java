package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinScoreOfAPathBetween2Cities {
    int res = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        HashSet<Integer> visiting = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());

        for(int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        dfs(adj, 1, visiting, visited);
        return res;
    }

    private void dfs(HashMap<Integer, List<int[]>> adj, int source, HashSet<Integer> visiting, HashSet<Integer> visited){
        if(visiting.contains(source) || visited.contains(source)) return;

        visiting.add(source);
        for(int[] nei : adj.get(source)){
            res = Math.min(nei[1], res);
            dfs(adj, nei[0], visiting, visited);
        }
        visiting.remove(source);
        visited.add(source);
    }
}
