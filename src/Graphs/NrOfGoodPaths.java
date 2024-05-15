package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NrOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        UF uf = new UF(vals.length);

        HashMap<Integer, List<Integer>> valMap = new HashMap<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < vals.length; i++){
            valMap.putIfAbsent(vals[i], new ArrayList<>());
            valMap.get(vals[i]).add(i);
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> keys = new ArrayList<>();
        for(int k : valMap.keySet()) keys.add(k);
        Collections.sort(keys);

        int res = 0;

        for(int k : keys){
            for(int n : valMap.get(k)){
                for(int nei : adj.get(n)){
                    if(vals[n] <= vals[nei]) uf.union(n, nei);
                }
            }

            HashMap<Integer, Integer> count = new HashMap<>();

            for(int n : valMap.get(k)){
                int r = uf.find(n);
                count.put(r, count.getOrDefault(r, 0)+1);
                res += count.get(r);
            }
        }

        return res;
    }
}
