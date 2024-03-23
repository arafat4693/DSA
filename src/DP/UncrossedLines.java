package DP;

import java.util.Arrays;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] cache = new int[nums1.length][nums2.length];
        for(int[] row : cache) Arrays.fill(row, -1);
        return dfs(nums1, nums2, 0, 0, cache);
    }

    private int dfs(int[] nums1, int[] nums2, int n1, int n2, int[][] cache){
        if(n1 >= nums1.length || n2 >= nums2.length) return 0;
        if(cache[n1][n2] != -1) return cache[n1][n2];

        int ans = 0;
        if(nums1[n1] == nums2[n2]) ans = 1 + dfs(nums1, nums2, n1+1, n2+1, cache);
        else ans = Math.max(dfs(nums1, nums2, n1, n2+1,cache), dfs(nums1, nums2, n1+1, n2, cache));

        return cache[n1][n2] = ans;
    }
}
