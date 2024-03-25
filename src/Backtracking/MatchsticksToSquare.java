package Backtracking;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0) return false;

        int target = sum / 4;
        Arrays.sort(matchsticks);
//        return backtrack(matchsticks, 0, target, 4, 0);

        int[] sides = new int[4];
        return backtrack(matchsticks, matchsticks.length-1, target, sides);
    }

    private boolean backtrack(int[] matchsticks, int idx, int target, int k, int subTarget){
        if(k == 0) return true;
        if(subTarget == target) return backtrack(matchsticks, 0, target, k-1, 0);

        for(int i = idx; i < matchsticks.length; i++){
            int tmp = matchsticks[i];
            if(tmp == -1) continue;
            if(subTarget+tmp > target) return false;
            matchsticks[i] = -1;
            if(backtrack(matchsticks, i+1, target, k, subTarget+tmp)) return true;
            matchsticks[i] = tmp;
        }

        return false;
    }

    private boolean backtrack(int[] matchsticks, int idx, int target, int[] sides){
        if(idx == -1) return true;

        for(int j = 0; j < sides.length; j++){
            if(sides[j]+matchsticks[idx] > target) continue;
            sides[j] += matchsticks[idx];
            if(backtrack(matchsticks, idx-1, target, sides)) return true;
            sides[j] -= matchsticks[idx];
        }

        return false;
    }
}
