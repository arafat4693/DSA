package ArrayAndHashing;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int total = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            total+=nums[i];
            if(map.containsKey(total-k)) res += map.get(total-k);
            map.put(total, map.getOrDefault(total, 0)+1);
        }
        return res;
    }
}
