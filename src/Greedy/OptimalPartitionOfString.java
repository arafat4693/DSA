package Greedy;

import java.util.HashSet;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int count = 1;
        HashSet<Character> seen = new HashSet<>();

        for(int r = 0; r < s.length(); r++){
            if(seen.contains(s.charAt(r))){
                count++;
                seen.clear();
            }
            seen.add(s.charAt(r));
        }

        return count;
    }
}
