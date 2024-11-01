package DP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxBrick = new PriorityQueue<>((a, b) -> b - a);
        int i;
        for(i = 0; i < heights.length-1; i++){
            int diff = heights[i+1] - heights[i];

            if(diff <= 0) continue;

            if(diff <= bricks){
                bricks -= diff;
                maxBrick.add(diff);
            }else {
                if(ladders == 0) break;

                if(!maxBrick.isEmpty()){
                    int max = maxBrick.peek();
                    if(max >= diff){
                        bricks += max;
                        bricks -= diff;
                        maxBrick.poll();
                        maxBrick.add(diff);
                    }
                }

                ladders--;
            }
        }

        return i;
    }
}
