package ArrayAndHashing;

import java.util.HashMap;

public class ContinuesSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> rem = new HashMap<>();
        rem.put(0, -1);
        
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            if(!rem.containsKey(total%k)){
                rem.put(total%k, i);
                continue;
            }

            if(i-rem.get(total%k) >= 2) return true;
        }

        return false;
    }
}
