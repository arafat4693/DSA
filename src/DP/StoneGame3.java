package DP;

import java.util.Arrays;

public class StoneGame3 {
    public String stoneGameIII(int[] stoneValue) {
        int sum = 0;
        for(int s : stoneValue) sum += s;

        int[][] cache = new int[stoneValue.length][2];
        for(int[] row : cache) Arrays.fill(row, -1);

        int a = dfs(stoneValue, 0, 0, cache);
        // System.out.println(a);

        if(sum-a > a) return "Bob";
        else if(sum-a < a) return "Alice";
        else return "Tie";
    }

    private int dfs(int[] stoneValue, int idx, int turn, int[][] cache){
        if(idx >= stoneValue.length) return 0;
        if(cache[idx][turn] != -1) return cache[idx][turn];

        int sum = 0, total = (turn == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);

        for(int i = idx; i < Math.min(idx+3, stoneValue.length); i++){
            sum += stoneValue[i];
            if(turn == 0){
                total = Math.max(total, sum + dfs(stoneValue, i+1, 1, cache));
            }else{
                total = Math.min(total, dfs(stoneValue, i+1, 0, cache));
            }
        }
        // System.out.println("t: " + turn + " tot: " + total + " idx: " + idx);
        return cache[idx][turn] = total;
    }
}
