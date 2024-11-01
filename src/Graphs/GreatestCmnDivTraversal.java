package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GreatestCmnDivTraversal {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UF uf = new UF(n);

        HashMap<Integer, List<Integer>> adj = new HashMap<>(); //{prime: [idx]}

        for(int i = 0; i < n; i++){
            getPrimes(i, nums[i], adj);
        }

        int c = n;

        for(int k : adj.keySet()){
            List<Integer> elms = adj.get(k);
            for(int i = 0; i < elms.size()-1; i++){
                if(uf.union(elms.get(i), elms.get(i+1))) c--;
            }
        }

        return c == 1;
    }

    private void getPrimes(int idx, int num, HashMap<Integer, List<Integer>> adj){
        int sqr = (int)Math.sqrt(num) + 1;

        for(int i = 2; i <= sqr; i++){
            if(num % i == 0) {
                adj.putIfAbsent(i, new ArrayList<>());
                adj.get(i).add(idx);
            }

            while(num % i == 0) num /= i;
        }

        if(num > 2) {
            adj.putIfAbsent(num, new ArrayList<>());
            adj.get(num).add(idx);
        }
    }
}
