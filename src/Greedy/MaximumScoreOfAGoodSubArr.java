package Greedy;

public class MaximumScoreOfAGoodSubArr {
    public int maximumScore(int[] nums, int k) {
        // int score = 0;
        // for(int i = 0; i <= k; i++){
        //     int mn = Integer.MAX_VALUE;
        //     for(int j = i; j <= k; j++) mn = Math.min(mn, nums[j]);

        //     for(int j = k; j < nums.length; j++){
        //         mn = Math.min(mn, nums[j]);
        //         score = Math.max(score, (j-i+1)*mn);
        //     }
        // }
        // return score;

        int i = k, j = k, min = nums[k], res = nums[k];

        while(i > 0 || j < nums.length-1){
            int r = 0, l = 0;

            if(j+1 <= nums.length-1) r = nums[j+1];
            if(i-1 >= 0) l = nums[i-1];

            if(r > l) j++;
            else i--;

            min = Math.min(min, Math.max(l,r));
            res = Math.max(res, min * (j-i+1));
        }

        return res;
    }
}
