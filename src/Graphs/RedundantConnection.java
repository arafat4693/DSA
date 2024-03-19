package Graphs;

import java.util.*;

public class RedundantConnection {
//    public int[] findRedundantConnection(int[][] edges) {
//        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
//        HashSet<Integer> visited = new HashSet<>();
//        HashSet<List<Integer>> cycles = new HashSet<>();
//
//        for(int[] edge : edges){
//            if(!adjList.containsKey(edge[0])) adjList.put(edge[0], new ArrayList<>());
//            if(!adjList.containsKey(edge[1])) adjList.put(edge[1], new ArrayList<>());
//        }
//
//        for(int[] edge : edges){
//            if(!adjList.get(edge[0]).isEmpty() && !adjList.get(edge[1]).isEmpty() && dfs(visited, adjList, edge[0], edge[1])) return edge;
//            adjList.get(edge[0]).add(edge[1]);
//            adjList.get(edge[1]).add(edge[0]);
//        }
//
//        throw new AssertionError();
//    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];

        for(int i = 0; i < edges.length + 1; i++) parent[i] = i;
        Arrays.fill(rank, 1);

        for(int[] edge: edges){
            if(!union(edge[0], edge[1], rank, parent)) return edge;
        }

        System.out.println(Arrays.toString(parent));
        throw new AssertionError();
    }

    private int find(int node, int[] parent){
        int par = parent[node];
        if(node == par) return par;
        return find(par, parent);
    }

    private boolean union(int u, int v, int[] rank, int[] parent){
        int p1 = find(u, parent), p2 = find(v, parent);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            rank[p1]+= rank[p2];
            parent[p2] = p1;
        }else{
            rank[p2]+= rank[p1];
            parent[p1] = p2;
        }

        return true;
    }

    private boolean dfs(HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjList, int source, int destination){
        if(visited.contains(source)) return false;

        if(source == destination) return true;

        visited.add(source);
        for(Integer n : adjList.get(source)){
            if(dfs(visited, adjList, n, destination)) return true;
        }
        visited.remove(source);

        return false;
    }

    public static void main(String[] args) {
        HashSet<List<Integer>> s = new HashSet<>();
        s.add(Arrays.asList(1,3));
        System.out.println(s.contains(Arrays.asList(1,3)));
    }
}
