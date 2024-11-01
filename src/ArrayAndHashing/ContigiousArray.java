package ArrayAndHashing;

import java.util.HashMap;

public class ContigiousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int total = 0, res = 0;
        for(int i = 0; i < n; i++){
            total += (nums[i] == 0 ? -1 : 1);
            if(map.containsKey(total)) res = Math.max(res, i-map.get(total));
            else map.put(total, i);
        }
        return res;
    }
}
