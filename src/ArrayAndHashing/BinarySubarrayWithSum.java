package ArrayAndHashing;

import java.util.HashMap;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        int total = 0, res = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            total += nums[i];
//            if(map.containsKey(total - goal)) res += map.get(total-goal);
//            map.put(total, map.getOrDefault(total, 0)+1);
//        }
//
//        return res;

        int res = 0, total = 0, l = 0, zeros = 0;

        for(int r = 0; r < nums.length; r++){
            total += nums[r];

            while(l < r && (nums[l] == 0 || total > goal)){
                if(nums[l] == 0) zeros++;
                else zeros = 0;
                total -= nums[l++];
            }

            if(total == goal) res += (1 + zeros);
        }

        return res;
    }
}
