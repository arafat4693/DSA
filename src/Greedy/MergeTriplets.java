package Greedy;

import java.util.ArrayList;
import java.util.List;

public class MergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean one = false, two = false, three = false;

        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;

            if(t[0] == target[0]) one = true;
            if(t[1] == target[1]) two = true;
            if(t[2] == target[2]) three = true;
        }

        return one && two && three;
    }
}
