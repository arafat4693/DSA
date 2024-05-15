package ArrayAndHashing;

import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(idxMap.containsKey(nums[i])){
                int prev = idxMap.get(nums[i]);
                if(Math.abs(prev - i) <= k) return true;
            }
            idxMap.put(nums[i], i);
        }

        return false;
    }
}
