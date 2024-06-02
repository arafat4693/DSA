package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinTimeToCollectApplesInTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(adj, hasApple, 0, -1);
    }

    private int dfs(HashMap<Integer, List<Integer>> adj, List<Boolean> hasApple, int src, int prev){
        int ans = 0;
        for(int nei : adj.get(src)){
            if(nei == prev) continue;
            ans += (1 + dfs(adj, hasApple, nei, src));
        }
        if(hasApple.get(src)) return 1 + ans;
        return ans > 0 ? 1 + ans : ans;
    }
}
