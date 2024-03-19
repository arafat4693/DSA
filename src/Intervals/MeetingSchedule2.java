package Intervals;

import java.util.*;

public class MeetingSchedule2 {
    public static int minMeetingRooms(List<Interval> intervals) {
        int[][] intervalsArr = new int[intervals.size()][2];
        for(int i = 0; i < intervals.size(); i++) intervalsArr[i] = new int[]{intervals.get(i).start, intervals.get(i).end};
        Arrays.sort(intervalsArr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int[] ints : intervalsArr) {
            if (!minHeap.isEmpty() && minHeap.peek() <= ints[0]) minHeap.poll();
            minHeap.add(ints[1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(4, 8));
        intervals.add(new Interval(5, 9));

        System.out.println(minMeetingRooms(intervals));
    }
}
