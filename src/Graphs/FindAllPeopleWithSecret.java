package Graphs;

import java.util.*;

public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int[] meeting : meetings){
            adj.get(meeting[0]).add(new int[]{meeting[1], meeting[2]});
            adj.get(meeting[1]).add(new int[]{meeting[0], meeting[2]});
        }

        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //[person, time]
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();

            if(visited.contains(top[0])) continue;
            visited.add(top[0]);

            for(int[] nei : adj.get(top[0])){
                if(visited.contains(nei[0]) || nei[1] < top[1]) continue;
                pq.add(nei);
            }
        }

        return new ArrayList<>(visited);
    }
}
