package Graphs;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            if(dfs(graph, visited, i)) ans.add(i);
        }

        return ans;
    }

    private boolean dfs(int[][] graph, HashMap<Integer, Boolean> visited, int src){
        if(visited.containsKey(src)) return visited.get(src);

        visited.put(src, false);

        for(int n : graph[src]){
            if(!dfs(graph, visited, n)) return false;
        }

        visited.put(src, true);
        return true;
    }
}
