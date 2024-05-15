package TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;

        int l = 0, r = people.length-1;

        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
            }else if(people[l] + people[r] > limit) {
                r--;
            }
            boats++;
        }

        return boats;
    }
}
