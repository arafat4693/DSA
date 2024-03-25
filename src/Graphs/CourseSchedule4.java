package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule4 {
//    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
//        List<Boolean> res = new ArrayList<>(queries.length);
//
//        HashSet<Integer> visited = new HashSet<>();
//
//        HashMap<Integer, List<Integer>> adj = new HashMap<>();
//        for(int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());
//
//        for(int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);
//
//        for(int[] query : queries){
//            visited.clear();
//            res.add(dfs(adj, query[0], query[1], visited));
//        }
//
//        return res;
//    }
//
//    private boolean dfs(HashMap<Integer, List<Integer>> adj, int pre , int course, HashSet<Integer> visited){
//        if(pre == course) return true;
//        if(visited.contains(course)) return false;
//
//        for(Integer nei : adj.get(course)){
//            if(dfs(adj, pre, nei, visited)) return true;
//        }
//
//        visited.add(course);
//
//        return false;
//    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>(queries.length);

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());

        for(int[] pre : prerequisites) adj.get(pre[0]).add(pre[1]);

        boolean[][] reachable = new boolean[numCourses][numCourses];

        for(int i = 0; i < numCourses; i++) dfs(adj, reachable, i, i);

        for(int[] query : queries) res.add(reachable[query[0]][query[1]]);

        return res;
    }

    private void dfs(HashMap<Integer, List<Integer>> adj, boolean[][] reachable, int s, int c){
        reachable[s][c] = true;
        for(Integer nei : adj.get(c)){
            if(!reachable[s][nei]) dfs(adj, reachable, s, nei);
        }
    }
}
