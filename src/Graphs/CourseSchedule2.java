package Graphs;

import java.util.*;

public class CourseSchedule2 {
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
//        HashSet<Integer> visited = new HashSet<>();
//        List<Integer> res = new ArrayList<>();
//
//        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());
//        for(int[] p : prerequisites) adjList.get(p[1]).add(p[0]);
//
//        for(Integer k : adjList.keySet()){
//            if(!dfs(k, visited, adjList, res)) return new int[]{};
//            if(!res.contains(k)) res.add(0, k);
//        }
//
//        int[] ans = new int[res.size()];
//        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);
//
//        return ans;
//    }
//
//    private static boolean dfs(int k, HashSet<Integer> v, HashMap<Integer, List<Integer>> adjList, List<Integer> res){
//        if(v.contains(k)) return false;
//        if(adjList.get(k).isEmpty()) return true;
//
//        v.add(k);
//        for(Integer p : adjList.get(k)){
//            if(!dfs(p, v, adjList, res)) return false;
//            if(!res.contains(p)) res.add(0, p);
//        }
//        v.remove(k);
//        adjList.put(k, new ArrayList<>());
//
//        return true;
//    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        HashSet<Integer> visited = new LinkedHashSet<>();
        HashSet<Integer> visiting = new HashSet<>();

        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());
        for(int[] p : prerequisites) adjList.get(p[0]).add(p[1]);

        for(Integer k : adjList.keySet()){
            if(!dfs(k, visited, visiting, adjList)) return new int[]{};
        }
        int[] ans = new int[visited.size()];

        int idx = 0;
        for(Integer v : visited){
            ans[idx++] = v;
        }

        return ans;
    }

    private static boolean dfs(int k, HashSet<Integer> visited, HashSet<Integer> visiting, HashMap<Integer, List<Integer>> adjList){
        if(visiting.contains(k)) return false;
        if(visited.contains(k)) return true;

        visiting.add(k);
        for(Integer p : adjList.get(k)){
            if(!dfs(p, visited, visiting, adjList)) return false;
        }
        visited.add(k);
        visiting.remove(k);

        return true;
    }

    public static void main(String[] args) {
        int[][] pre = new int[][]{{1,0}};
        int[] order = findOrder(2, pre);
        System.out.println(Arrays.toString(order));
    }
}
