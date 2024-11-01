package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = healths.length;
        int[][] rphd = new int[n][4];

        for(int i = 0; i < n; i++) {
            int pos = positions[i];
            int health = healths[i];
            int dir = directions.charAt(i) == 'R' ? 1 : -1;

            rphd[i] = new int[]{i, pos, health, dir};
        }

        Arrays.sort(rphd, (a, b) -> a[1] - b[1]);

        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int[] curr = rphd[i];

            while(!st.isEmpty() && curr[3] == -1) {
                int[] top = st.peek();
                if(top[2] > curr[2]){
                    top[2]--;
                    curr[3] = 0;
                    break;
                }
                else if(top[2] < curr[2]){
                    curr[2]--;
                    st.pop();
                } else {
                    st.pop();
                    curr[3] = 0;
                    break;
                }
            }

            if(curr[3] != 0) st.add(curr);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        while(!st.isEmpty()) ans[(st.peek()[0])] = st.pop()[2];

        List<Integer> res = new ArrayList<>();
        for(int h : ans) {
            if(h != -1) res.add(h);
        }

        return res;
    }
}
