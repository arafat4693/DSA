package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindClosestNodeToGivenNode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int res = Integer.MAX_VALUE, n = -1;
        HashMap<Integer, int[]> distance = new HashMap<>();
        distance.put(node1, new int[edges.length]);
        distance.put(node2, new int[edges.length]);

        Arrays.fill(distance.get(node1), Integer.MAX_VALUE);
        Arrays.fill(distance.get(node2), Integer.MAX_VALUE);

        dfs(edges, node1, node1, distance, 0, new HashSet<>());
        dfs(edges, node2, node2, distance, 0, new HashSet<>());

        for(int i = 0; i < edges.length; i++){
            int d1 = distance.get(node1)[i];
            int d2 = distance.get(node2)[i];

            if(d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE){
                int mx = Math.max(d1, d2);
                if(res > mx) {
                    n = i;
                    res = mx;
                };
            }
        }

        return n;
    }

    private void dfs(int[] edges, int node, int src, HashMap<Integer, int[]> distance, int d, HashSet<Integer> visiting){
        if(visiting.contains(node)) return;
        distance.get(src)[node] = d;
        if(edges[node] != -1){
            visiting.add(node);
            dfs(edges, edges[node], src, distance, d+1, visiting);
        }
    }
}
