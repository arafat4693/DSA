package HeapPQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] roomCnt = new int[n];

        PriorityQueue<Integer> rooms = new PriorityQueue<>((a, b) -> a - b); // [room]
        for(int i = 0; i < n; i++) rooms.add(i);

        PriorityQueue<int[]> running = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        }); // [end, room]

        for (int[] meeting : meetings) {
            while (!running.isEmpty() && running.peek()[0] <= meeting[0]) rooms.add(running.poll()[1]);

            if (running.size() < n) {
                running.add(new int[]{meeting[1], rooms.peek()});
                roomCnt[rooms.poll()]++;
            } else {
                int[] done = running.poll();
                running.add(new int[]{meeting[1] - meeting[0] + done[0], done[1]});
                roomCnt[done[1]]++;
            }
        }

        int mx = 0, room = Integer.MAX_VALUE;
        for(int r = 0; r < roomCnt.length; r++){
            if(roomCnt[r] > mx){
                mx = roomCnt[r];
                room = r;
            }
        }

        return room;
    }
}
