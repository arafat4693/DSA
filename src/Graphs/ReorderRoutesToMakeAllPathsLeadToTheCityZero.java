package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
//    public int minReorder(int n, int[][] connections) {
//        HashMap<Integer, HashSet<Integer>> cons = new HashMap<>();
//        HashMap<Integer, List<Integer>> adj = new HashMap<>();
//        HashSet<Integer> visited = new HashSet<>();
//
//        for(int i = 0; i < n; i++){
//            adj.put(i, new ArrayList<>());
//            cons.put(i, new HashSet<>());
//        }
//
//        for(int[] con : connections){
//            cons.get(con[0]).add(con[1]);
//            adj.get(con[0]).add(con[1]);
//            adj.get(con[1]).add(con[0]);
//        }
//
//        return dfs(adj, cons, 0, visited);
//    }
//
//    private int dfs(HashMap<Integer, List<Integer>> adj, HashMap<Integer, HashSet<Integer>> cons, int node, HashSet<Integer> visited){
//        int res = 0;
//        visited.add(node);
//        for(Integer nei : adj.get(node)){
//            if(!visited.contains(nei)){
//                res += (dfs(adj, cons, nei, visited) + (cons.get(node).contains(nei) ? 1 : 0));
//            }
//        }
//        return res;
//    }

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] con : connections){
            adj.get(con[0]).add(con[1]);
            adj.get(con[1]).add(-con[0]);
        }

        return dfs(adj, 0, visited);
    }

    private int dfs(HashMap<Integer, List<Integer>> adj, int node, HashSet<Integer> visited){
        int res = 0;
        visited.add(node);
        for(Integer nei : adj.get(node)){
            int n = Math.abs(nei);
            if(!visited.contains(n)){
                res += (dfs(adj, n, visited) + (nei > 0 ? 1 : 0));
            }
        }
        return res;
    }
}
