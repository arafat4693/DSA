package ArrayAndHashing;

import java.util.HashMap;

public class MakeSumDivByP {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;

        int[] pre = new int[n];
        pre[0] = nums[0] % p;

        for (int i = 1; i < n; i++) {
            pre[i] = (nums[i] + pre[i - 1]) % p;
        }

        int target = pre[n - 1] % p;

        if (target == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            int curr = pre[i];
            int prev = (curr - target + p) % p;

            if (map.containsKey(prev)) {
                int j = map.get(prev);
                ans = Math.min(ans, i - j);
            }
            map.put(curr, i);
        }

        return ans == n ? -1 : ans;
    }

}
