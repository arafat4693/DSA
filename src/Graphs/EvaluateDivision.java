package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    static class Edge{
        String node;
        double weight;

        Edge(String node, double weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Edge>> adj = new HashMap<>();
        HashSet<String> visiting = new HashSet<>();
        double[] res = new double[queries.size()];

        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            adj.putIfAbsent(eq.get(0), new ArrayList<>());
            adj.putIfAbsent(eq.get(1), new ArrayList<>());

            adj.get(eq.get(0)).add(new Edge(eq.get(1), values[i]));
            adj.get(eq.get(1)).add(new Edge(eq.get(0), 1 / values[i]));
        }

        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            if(!adj.containsKey(query.get(0)) || !adj.containsKey(query.get(1))){
                res[i] = -1.0;
                continue;
            }
            visiting.clear();
            res[i] = dfs(adj, query.get(0), query.get(1), 1, visiting);
        }

        return res;
    }

    private double dfs(HashMap<String, List<Edge>> adj, String source, String dest, double total, HashSet<String> visiting){
        if(source.equals(dest)) return total;
        if(visiting.contains(source)) return 0;

        visiting.add(source);
        for(Edge nei : adj.get(source)){
            double ans = dfs(adj, nei.node, dest, total * nei.weight, visiting);
            if(ans != 0) return ans;
        }
        visiting.remove(source);

        return 0;
    }
}
