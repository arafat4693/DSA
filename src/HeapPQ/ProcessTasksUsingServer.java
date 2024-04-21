package HeapPQ;

import java.util.PriorityQueue;

public class ProcessTasksUsingServer {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];

        // [value, index, time] -> servers
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        // [value, index] -> servers
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> { // [value, index] -> servers
            if(a[0] - b[0] == 0) return a[1] - b[1];
            return a[0] - b[0];
        });

        for(int i = 0; i < servers.length; i++) free.add(new int[]{servers[i], i});

        int time = 0;

        for(int i = 0; i < tasks.length; i++){
            time = Math.max(time, i);

            if(free.isEmpty()){
                time = busy.peek()[2];
            }

            while(!busy.isEmpty() && time == busy.peek()[2]) free.add(new int[]{busy.peek()[0], busy.poll()[1]});

            int[] freeServer = free.poll();
            res[i] = freeServer[1];
            busy.add(new int[]{freeServer[0], freeServer[1], time + tasks[i]});
        }

        return res;
    }
}
