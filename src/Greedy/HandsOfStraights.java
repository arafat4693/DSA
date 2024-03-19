package Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class HandsOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int h : hand) freq.put(h, freq.getOrDefault(h, 0)+1);

        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            if(freq.get(hand[i]) == 0) continue;
            freq.put(hand[i], freq.get(hand[i])-1);

            for(int j = 1; j < groupSize; j++){
                if(freq.get(hand[i]+j) == null) return false;
                freq.put(hand[i]+j, freq.get(hand[i]+j)-1);
            }
        }

        for(Integer k : freq.keySet()){
            if(freq.get(k) != 0) return false;
        }

        return true;
    }
}
