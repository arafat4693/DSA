package Graphs;

import java.util.*;
import java.util.logging.Handler;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int[] edge : edges){
            if(!union(edge[0], edge[1], parent)) return false;
        }
        boolean leader = false;
        for(int p : parent){
            if(p < 0){
                if(leader) return false;
                else leader = true;
            }
        }
        return true;
    }

    private static int find(int node, int[] parent){
        int par = parent[node];
        if(par < 0) return node;
        return find(par, parent);
    }

    private static boolean union(int u, int v, int[] parent){
        int l1 = find(u, parent), l2 = find(v, parent);
        if(l1 == l2) return false;
        if(parent[l1] < parent[l2]){
            parent[l1] += parent[l2];
            parent[l2] = l1;
        }else{
            parent[l2] += parent[l1];
            parent[l1] = l2;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println(validTree(n, edges));
    }
}
