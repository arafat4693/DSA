package Graphs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Queue<Integer>> adjList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int[] p : prerequisites) {
            if(!adjList.containsKey(p[1])) adjList.put(p[1], new LinkedList<>());
            if(!adjList.containsKey(p[0])) adjList.put(p[0], new LinkedList<>());
            adjList.get(p[1]).add(p[0]);
        }

        for(Integer k : adjList.keySet()){
            if(!adjList.get(k).isEmpty()) {
                if(!dfs(k, visited, adjList)) return false;
            }
        }

        return true;
    }

    private boolean dfs(Integer k, HashSet<Integer> v, HashMap<Integer, Queue<Integer>> adjList){
        if(v.contains(k)) return false;

        Queue<Integer> p = adjList.get(k);

        if(p.isEmpty()) return true;

        v.add(k);
        while(!p.isEmpty()){
            if(!dfs(p.peek(), v, adjList)) return false;
            p.poll();
        }

        v.remove(k);

        return true;

//        for(int i = 0; i < adjList.get(k).size(); i++){
//            if(!dfs(p.get(i), v, adjList)) return false;
//            p = p.subList(i+1, p.size());
//        }
    }
}
