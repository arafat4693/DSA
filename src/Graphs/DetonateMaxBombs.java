package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DetonateMaxBombs {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < bombs.length; i++){
            adj.putIfAbsent(i, new ArrayList<>());
            for(int j = 0; j < bombs.length; j++){
                if(i == j) continue;
                if(overlapping(bombs[i], bombs[j])){
                    adj.get(i).add(j);
                }
            }
        }

        System.out.println(adj);

        HashSet<Integer> visited = new HashSet<>();
        int res = 0;

        for(int i = 0; i < bombs.length; i++){
            dfs(adj, visited, i);
            if(visited.size() == bombs.length) return bombs.length;
            res = Math.max(res, visited.size());
            visited.clear();
        }

        return res;
    }

    private void dfs(HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited, int node){
        if(visited.contains(node)) return;

        visited.add(node);
        for(int n : adj.get(node)){
            if(!visited.contains(n)){
                dfs(adj, visited, n);
            }
        }
    }

    private boolean overlapping(int[] c1, int[] c2){
        long distance = ((long) (c2[0] - c1[0]) *(c2[0] - c1[0]) + (long) (c2[1] - c1[1]) *(c2[1] - c1[1]));
        return ((long) c1[2] *c1[2]) >= distance;
    }
}
