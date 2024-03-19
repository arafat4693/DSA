package Intervals;

import java.util.Arrays;
import java.util.List;

public class MeetingSchedule {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;

        int[][] intervalsArr = new int[intervals.size()][2];
        for(int i = 0; i < intervals.size(); i++) intervalsArr[i] = new int[]{intervals.get(i).start, intervals.get(i).end};
        Arrays.sort(intervalsArr, (a, b) -> a[0] - b[0]);

        int prevEnd = intervalsArr[0][1];

        for(int i = 1; i < intervals.size(); i++){
            if(intervalsArr[i][0] < prevEnd) return false;
            prevEnd = intervalsArr[i][1];
        }

        return true;
    }
}
