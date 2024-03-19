package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> {
            if(a.get(0).compareTo(b.get(0)) == 0) {
                return a.get(1).compareTo(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        HashMap<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        dfs("JFK", adj, res, tickets.size());
        return res;
    }

    private boolean dfs(String src, HashMap<String, List<String>> adj, List<String> res, int tSize){
        if(res.size() == tSize+1) return true;
        if(!adj.containsKey(src)) return false;

        for(int i = 0; i < adj.get(src).size(); i++){
            String to = adj.get(src).get(i);
            if(to.equals("***")) continue;
            res.add(to);
            adj.get(src).set(i, "***"); //mark as visited
            if(dfs(to, adj, res, tSize)) return true;
            res.remove(res.size()-1);
            adj.get(src).set(i, to);
        }

        return false;
    }
}
