package DP;

public class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        return dfs(days, costs, 0, cache);
    }

    private int dfs(int[] days, int[] cost, int idx, int[] cache){
        if(idx >= days.length) return 0;
        if(cache[idx] != 0) return cache[idx];

        int ans = cost[0] + dfs(days, cost, idx+1, cache); // 1 day pass
        ans = Math.min(ans, cost[1] + dfs(days, cost, getIdx(idx, days, 7), cache)); // 7 days pass
        ans = Math.min(ans, cost[2] + dfs(days, cost, getIdx(idx, days, 30), cache)); // 30 days pass

        return cache[idx] = ans;
    }

    private int getIdx(int idx, int[] days, int pass){
        int target = days[idx] + pass, l = idx+1, r = days.length-1, ans = days.length;

        while(l <= r){
            int mid = (l+r)/2;
            if(days[mid] == target) return mid;
            else if(days[mid] < target) l = mid+1;
            else {
                ans = mid;
                r = mid-1;
            }
        }

        return ans;
    }
}
