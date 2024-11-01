package Graphs;

import java.util.*;

public class LargestColorValueInGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int[] edge : edges) adj.get(edge[0]).add(edge[1]);

        int[][] cache = new int[n][26];

        int res = 0;
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            res = Math.max(res, dfs(adj, i, cache, colors, visited, new HashSet<>()));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(HashMap<Integer, List<Integer>> adj, int src, int[][] cache, String colors, HashSet<Integer> visited, HashSet<Integer> visiting){
        if(visiting.contains(src)) return Integer.MAX_VALUE;
        if(visited.contains(src)) return 0;

        visited.add(src);
        visiting.add(src);

        cache[src][colors.charAt(src) - 'a'] = 1;

        for(int nei : adj.get(src)){
            if(dfs(adj, nei, cache, colors, visited, visiting) == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            for(int i = 0; i < 26; i++){
                cache[src][i] = Math.max(cache[src][i], cache[nei][i] + (colors.charAt(src)-'a' == i ? 1 : 0));
            }
        }

        visiting.remove(src);

        int mx = 0;
        for(int c : cache[src]) mx = Math.max(c, mx);

        return mx;
    }
}
