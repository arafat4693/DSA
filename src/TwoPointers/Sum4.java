package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int one = nums[i];

            for(int j = i+1; j < nums.length - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int two = nums[j];

                int left = j+1, right = nums.length-1;

                while(left < right){
                    long sum = (long) one+two+nums[left]+nums[right];

                    if(sum == target){
                        List<Integer> subRes = new ArrayList<>(Arrays.asList(one, two, nums[left], nums[right]));
                        res.add(subRes);

                        right--;
                        while(left < right && nums[right] == nums[right+1]) right--;

                    }else if(sum < target) left++;
                    else right--;
                }
            }
        }

        return res;
    }
}
