package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
//    public boolean isBipartite(int[][] graph) {
//        HashSet<Integer> setA = new HashSet<>();
//        HashSet<Integer> setB = new HashSet<>();
//        HashSet<Integer> visited = new HashSet<>();
//
//        Queue<Integer> q = new LinkedList<>();
//
//        for(int i = 0; i < graph.length; i++){
//            if(visited.contains(i)) continue;
//
//            q.add(i);
//
//            while(!q.isEmpty()){
//                int top = q.poll();
//                if(visited.contains(top)) continue;
//                visited.add(top);
//
//                for(int n : graph[top]){
//                    if(!visited.contains(n)){
//                        if(setA.contains(top) && setA.contains(n)) return false;
//                        if(setB.contains(top) && setB.contains(n)) return false;
//
//                        if(setA.contains(top)) setB.add(n);
//                        else if(setB.contains(top)) setA.add(n);
//                        else {
//                            setA.add(top);
//                            setB.add(n);
//                        }
//
//                        q.add(n);
//                    }
//                }
//            }
//        }
//
//        return true;
//    }


    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            if(color[i] != 0) continue;

            q.add(i);
            color[i] = 1;

            while(!q.isEmpty()){
                int top = q.poll();

                for(int n : graph[top]){
                    if(color[top] == color[n]) return false;
                    if(color[n] == 0){
                        color[n] = -color[top];
                        q.add(n);
                    }
                }
            }
        }

        return true;
    }
}
