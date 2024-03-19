package Graphs;

import java.util.HashMap;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> hm = new HashMap<>();
        return dfs(node, hm);
    }

    private Node dfs(Node node, HashMap<Node, Node> hm){
        if(node == null) return null;
        if(hm.containsKey(node)) return hm.get(node);
        Node copy = new Node(node.val);
        hm.put(node, copy);
        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(n, hm));
        }
        return copy;
    }
}
