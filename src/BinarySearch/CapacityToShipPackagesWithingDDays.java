package BinarySearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithingDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }

        int l = max, r = sum, res = sum;

        while(l <= r){
            int m = (l+r)/2;
            int d = 0, w = 0;

            for(int i = 0; i < weights.length; i++){
                w += weights[i];
                if (w > m) {
                    d++;
                    w = weights[i];
                }
            }
            if(w > 0) d++;

            if(d <= days){
                r = m-1;
                res = Math.min(res, m);
            }else l = m+1;
        }

        return res;
    }
}
