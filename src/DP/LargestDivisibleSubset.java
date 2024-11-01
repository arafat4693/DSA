package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LargestDivisibleSubset {
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//
//        HashSet<Integer>[] lisArr = new HashSet[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            lisArr[i] = new HashSet<>();
//            lisArr[i].add(nums[i]);
//        }
//
//        int mx = 0, mxIdx = -1;
//
//        for(int i = nums.length-1; i >= 0; i--){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[j]%nums[i] == 0 && lisArr[i].size() < 1+lisArr[j].size()){
//                    lisArr[i].clear();
//                    lisArr[i].add(nums[i]);
//                    lisArr[i].addAll(lisArr[j]);
//                }
//            }
//
//            if(mx < lisArr[i].size()){
//                mx = lisArr[i].size();
//                mxIdx = i;
//            }
//        }
//
//        return new ArrayList<>(lisArr[mxIdx]);
//    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int[] last = new int[nums.length];
        Arrays.fill(last, nums.length);

        int mx = 0, mxIdx = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && lis[i] < 1 + lis[j]) {
                    lis[i] = 1 + lis[j];
                    last[i] = j;
                }
            }

            if(mx < lis[i]){
                mx = lis[i];
                mxIdx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while(mxIdx < nums.length){
            res.add(nums[mxIdx]);
            mxIdx = last[mxIdx];
        }

        return res;
    }
}
