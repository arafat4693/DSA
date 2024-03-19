package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];
        int k = high;

        while(low <= high){
            int mid = (low + high) / 2;
            int time = 0;
            for (int pile : piles) {
                int div = pile / mid;
                int remainder = pile % mid;
                time += (div + (remainder != 0 ? 1 : 0));
                if (time > h) break;
            }
            if(time <= h){
                k = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return k;
    }
}
