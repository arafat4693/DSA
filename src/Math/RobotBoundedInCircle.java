package Math;

import java.util.Stack;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{ {0,1}, {-1,0}, {0,-1}, {1,0} };
        int x = 0, y = 0, d = 0;

        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                x += dirs[d][0];
                y += dirs[d][1];
            }else if(instructions.charAt(i) == 'L'){
                d = (d+1)%4;
            }else d = (d-1+instructions.length())%4;
        }

        return x == 0 && y == 0 || d != 0;
    }
}
