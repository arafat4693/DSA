package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class BestTeamWithNoConflict {
    public int bestTeamScore(int[] scores, int[] ages) {
        int mxAge = 0;
        for (int age : ages) mxAge = Math.max(mxAge, age);

        int[][] scoreAge = new int[scores.length][2];
        int[][] cache = new int[scores.length][mxAge+2];

        for(int[] row : cache) Arrays.fill(row, -1);

        for(int i = 0; i < scores.length; i++){
            scoreAge[i] = new int[]{scores[i], ages[i]};
        }

        Arrays.sort(scoreAge, (a, b) -> {
            if(a[0] - b[0] == 0) return a[1] - b[1];
            return a[0] - b[0];
        });

        return dfs(scoreAge, 0, -1, cache);
    }

    private int dfs(int[][] scoreAge, int idx, int prevAge, int[][] cache){
        if(idx >= scoreAge.length) return 0;
        if(cache[idx][prevAge+1] != -1) return cache[idx][prevAge+1];

        int ans = dfs(scoreAge, idx+1, prevAge, cache);
        if((prevAge == -1) || scoreAge[idx][1] >= prevAge) ans = Math.max(ans, scoreAge[idx][0] + dfs(scoreAge, idx+1, scoreAge[idx][1], cache));

        return cache[idx][prevAge+1] = ans;
    }
}
