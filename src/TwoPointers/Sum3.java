package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//
//        List<List<Integer>> ans = new ArrayList<>();
//        HashSet<String> seen = new HashSet<>();
//
//        for(int i = 0; i < nums.length-2; i++){
//            int target = nums[i] * -1;
//            int left = i+1;
//            int right = nums.length - 1;
//
//            if(seen.contains(nums[i] + "-" + nums[left] + "-" + nums[right])) continue;
//
//            while(left < right){
//                int sum = nums[left] + nums[right];
//                if(sum > target) right--;
//                else if(sum < target) left++;
//                else {
//                    if(seen.add(nums[i] + "-" + nums[left] + "-" + nums[right])) {
//                        List<Integer> subAns = new ArrayList<>();
//                        subAns.add(nums[i]);
//                        subAns.add(nums[left]);
//                        subAns.add(nums[right]);
//
//                        ans.add(subAns);
//
//                        new HashSet<>(ans).;
//                    };
//                    right--;
//                    left++;
//                }
//            }
//        }
//
//        return ans;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int target = nums[i] * -1;
            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum > target) right--;
                else if(sum < target) left++;
                else {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[left]);
                    subAns.add(nums[right]);

                    ans.add(subAns);

                    right--;

                    while(nums[right] == nums[right+1] && left < right) right--;
                }
            }
        }

        return ans;
    }
}