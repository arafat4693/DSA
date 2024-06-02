package DP;

import java.util.Arrays;
import java.util.HashMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) freq.put(n, freq.getOrDefault(n, 0)+1);

        int i = 0;
        int[] newNums = new int[freq.size()];
        for(int k : freq.keySet()) newNums[i++] = k;
        Arrays.sort(newNums);

        int[] cache = new int[newNums.length];
        Arrays.fill(cache, -1);

        return dfs(newNums, i, cache, freq);
    }

    private int dfs(int[] nums, int i, int[] cache, HashMap<Integer, Integer> freq){
        if(i >= nums.length) return 0;
        if(cache[i] != -1) return cache[i];

        int ans = dfs(nums, i+1, cache, freq);
        boolean next = i + 1 < nums.length && nums[i + 1] == nums[i]+1;
        ans = Math.max(ans, nums[i]*freq.get(nums[i]) + dfs(nums, next ? i+2 : i+1, cache, freq));

        return cache[i] = ans;
    }
}
