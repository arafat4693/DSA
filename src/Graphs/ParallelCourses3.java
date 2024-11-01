package Graphs;

import java.util.*;

public class ParallelCourses3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> pre = new HashMap<>();
        for(int i = 1; i <= n; i++) pre.put(i, new ArrayList<>());

        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);

        for(int[] relation : relations){
            int prev = relation[0], next = relation[1];
            pre.get(next).add(prev);
        }

        int res = 0;

        for(int i = 1; i <= n; i++){
            res = Math.max(res, dfs(pre, i, time, cache));
        }

        return res;
    }

    private int dfs(HashMap<Integer, List<Integer>> pre, int src, int[] time, int[] cache){
        if(cache[src] != -1) return cache[src];

        int mx = 0;
        for(int nei : pre.get(src)){
            mx = Math.max(mx, dfs(pre, nei, time, cache));
        }

        return cache[src] = time[src-1] + mx;
    }
}
