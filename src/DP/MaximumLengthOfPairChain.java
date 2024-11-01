package DP;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] lis = new int[pairs.length];
        Arrays.fill(lis, 1);

        int mx = 0;
        for(int i = pairs.length-1; i >= 0; i--){
            for(int j = i+1; j < pairs.length; j++){
                if(pairs[i][1] < pairs[j][0]) lis[i] = Math.max(lis[i], 1+lis[j]);
            }
            mx = Math.max(mx, lis[i]);
        }

        return mx;


//        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
//        int currEnd = pairs[0][1], ans = 1;
//
//        for(int i = 1; i < pairs.length; i++){
//            if(currEnd < pairs[i][0]){
//                ans++;
//                currEnd = pairs[i][1];
//            }
//        }
//
//        return ans;
    }
}
