package DP;

import java.util.Arrays;

public class SolvingQuestionsWithBrainPower {
    public long mostPoints(int[][] questions) {
        long[] cache = new long[questions.length];
        Arrays.fill(cache, -1);

        return dfs(questions, 0, cache);
    }

    private long dfs(int[][] questions, int idx, long[] cache){
        if(idx >= questions.length) return 0;
        if(cache[idx] != -1) return cache[idx];

        long ans = questions[idx][0] + dfs(questions, idx+questions[idx][1]+1, cache);
        ans = Math.max(ans, dfs(questions, idx+1, cache));

        return cache[idx] = ans;
    }
}
