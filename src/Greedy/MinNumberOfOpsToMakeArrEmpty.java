package Greedy;

import java.util.HashMap;

public class MinNumberOfOpsToMakeArrEmpty {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        int ans = 0;

        for(int k : map.keySet()){
            int freq = map.get(k);
            if(freq == 1) return -1;

            int rem = freq % 3;
            if(rem == 0) ans += freq/3;
            else {
                if(rem == 2) ans += (freq / 3) + 1;
                else ans += ((freq-4)/3 + 2);
            }
        }

        return ans;
    }
}
