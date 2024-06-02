package BinarySearch;

import java.util.Arrays;

public class NrOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        for(int i = 0; i < flowers.length; i++){
            int[] flower = flowers[i];
            start[i] = flower[0];
            end[i] = flower[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0; i < people.length; i++){
            int time = people[i];
            int bloomed = upperBound(time, start);
            int died = lowerBound(time, end);
            ans[i] = bloomed - died;
        }

        return ans;
    }

    private int upperBound(int target, int[] start){
        int l = 0, r = start.length-1, idx = -1;
        while(l <= r){
            int m = (l+r) / 2;
            if(start[m] > target){
                idx = m;
                r = m-1;
            }else l = m+1;
        }
        return idx == -1 ? start.length : idx;
    }

    private int lowerBound(int target, int[] end){
        int l = 0, r = end.length-1, idx = -1;
        while(l <= r){
            int m = (l+r) / 2;
            if(end[m] >= target){
                idx = m;
                r = m-1;
            }else l = m+1;
        }
        return idx == -1 ? end.length : idx;
    }
}
