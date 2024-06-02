package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCriticalAndPseudoInMST {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] allEdges = new int[edges.length][4];
        for(int i = 0; i < edges.length; i++) allEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};

        Arrays.sort(allEdges, (a, b) -> a[2] - b[2]);

        int weight = kruskal(n, allEdges, -1, -1);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for(int i = 0; i < allEdges.length; i++){
            int k = kruskal(n, allEdges, i, -1);
            if(k != weight) critical.add(allEdges[i][3]);
            else if(weight == kruskal(n, allEdges, -1, i)) pseudo.add(allEdges[i][3]);
        }

        res.add(critical);
        res.add(pseudo);
        return res;
    }

    private int kruskal(int n, int[][] edges, int ex, int in){
        UF uf = new UF(n);

        int weight = 0;

        if(in != -1) {
            int n1 = edges[in][0], n2 = edges[in][1], w = edges[in][2];
            uf.union(n1, n2);
            weight += w;
        }

        for(int i = 0; i < edges.length; i++){
            if(i == ex || i == in) continue;
            int n1 = edges[i][0], n2 = edges[i][1], w = edges[i][2];
            if(uf.union(n1, n2)) weight += w;
        }

        return weight;
    }
}
