package Graphs;

import java.util.Arrays;

public class CountConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int[] edge : edges){
            union(edge[0], edge[1], parent);
        }
        int count = 0;
        for(int p : parent) {
            if(p < 0) count++;
        }
        return count;
    }

    private static int find(int node, int[] parent){
        int par = parent[node];
        if(par < 0) return node;
        return find(par, parent);
    }

    private static void union(int u, int v, int[] parent){
        int l1 = find(u, parent), l2 = find(v, parent);
        if(l1 == l2) return; // cycle
        if(parent[l1] < parent[l2]){
            parent[l1] += parent[l2];
            parent[l2] = l1;
            //extra (Just for optimization)
            if(parent[u] >= 0) parent[u] = l1;
            parent[v] = l1;
        }else{
            parent[l2] += parent[l1];
            parent[l1] = l2;
            //extra (Just for optimization)
            parent[u] = l2;
            if(parent[v] >= 0) parent[v] = l2;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {4,5}};
        System.out.println(countComponents(n, edges));
    }
}
