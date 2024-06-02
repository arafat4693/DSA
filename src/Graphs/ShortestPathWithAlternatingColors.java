package Graphs;

import java.util.*;

public class ShortestPathWithAlternatingColors {
//    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        HashMap<Integer, List<int[]>> adj = new HashMap<>();
//        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
//
//        for(int i = 0; i < Math.max(redEdges.length, blueEdges.length); i++){
//            if(i < redEdges.length){
//                adj.get(redEdges[i][0]).add(new int[]{redEdges[i][1], 1});
//            }
//
//            if(i < blueEdges.length){
//                adj.get(blueEdges[i][0]).add(new int[]{blueEdges[i][1], -1});
//            }
//        }
//
//        return bfs(adj);
//    }
//
//    class State{
//        int n;
//        int c;
//
//        State(int n, int c){
//            this.n = n;
//            this.c = c;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof State state)) return false;
//            return n == state.n && c == state.c;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(n, c);
//        }
//    }
//
//    private int[] bfs(HashMap<Integer, List<int[]>> adj){
//        int[] path = new int[adj.size()];
//        Arrays.fill(path, -1);
//        path[0] = 0;
//
//        HashSet<State> seen = new HashSet<>();
//        seen.add(new State(0,0));
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{0, 0, 0}); // [node, color, length]
//
//        while(!q.isEmpty()){
//            int[] node = q.poll();
//            for(int[] nei : adj.get(node[0])){
//                if(nei[0] == 0 || node[1] == nei[1] || seen.contains(new State(nei[0], nei[1]))) continue;
//                if(path[nei[0]] == -1) path[nei[0]] = node[2]+1;
//                q.add(new int[]{nei[0], nei[1], node[2]+1});
//                seen.add(new State(nei[0], nei[1]));
//            }
//        }
//
//        return path;
//    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int i = 0; i < Math.max(redEdges.length, blueEdges.length); i++){
            if(i < redEdges.length){
                adj.get(redEdges[i][0]).add(new int[]{redEdges[i][1], 1});
            }

            if(i < blueEdges.length){
                adj.get(blueEdges[i][0]).add(new int[]{blueEdges[i][1], 0});
            }
        }

        return bfs(adj);
    }

    private int[] bfs(HashMap<Integer, List<int[]>> adj){
        int[] path = new int[adj.size()];
        Arrays.fill(path, -1);
        path[0] = 0;

        boolean[][] seen = new boolean[adj.size()][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1, 0}); // [node, color, length]

        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] nei : adj.get(node[0])){
                if(nei[0] == 0 || node[1] == nei[1] || seen[nei[0]][nei[1]]) continue;
                if(path[nei[0]] == -1) path[nei[0]] = node[2]+1;
                q.add(new int[]{nei[0], nei[1], node[2]+1});
                seen[nei[0]][nei[1]] = true;
            }
        }

        return path;
    }
}
