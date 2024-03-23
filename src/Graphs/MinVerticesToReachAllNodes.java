package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> incoming = new HashSet<>();

        for(List<Integer> edge : edges) incoming.add(edge.get(1));

        for(int i = 0; i < n; i++) {
            if(!incoming.contains(i)) res.add(i);
        }

        return res;
    }
}
