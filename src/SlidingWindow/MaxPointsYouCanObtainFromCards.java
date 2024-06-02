package SlidingWindow;

import java.util.Arrays;

public class MaxPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int[] pSum = new int[cardPoints.length];
        pSum[0] = cardPoints[0];
        for(int i = 1; i < cardPoints.length; i++) pSum[i] = pSum[i-1] + cardPoints[i];

        int i = k, res = 0;
        while(i >= 0){
            int left = pSum[i-1];
            int right = pSum[pSum.length-1] - pSum[pSum.length - k - i - 1];
            res = Math.max(res, left + right);
            i--;
        }

        return res;
    }
}
