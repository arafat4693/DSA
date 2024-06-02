package ArrayAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinDelToMakeCharFreqUnique {
    public int minDeletions(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
//        HashMap<Integer, Character> seen = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

        int removed = 0;

//        for(int i = 0; i < s.length(); i++){
//            int f = freq.get(s.charAt(i));
//            if(!seen.containsKey(f)) {
//                seen.put(f, s.charAt(i));
//                continue;
//            }
//
//            if(seen.get(f) == s.charAt(i)) continue;
//
//            while(seen.containsKey(f)) f--;
//
//            if(f <= 0){
//                freq.remove(s.charAt(i));
//                removed += freq.get(s.charAt(i));
//            }else{
//                removed += (freq.get(s.charAt(i)) - f);
//                freq.put(s.charAt(i), f);
//            }
//        }


        for(char k : freq.keySet()){
            int f = freq.get(k);
            while(f > 0 && seen.contains(f)){
                f--;
                removed++;
            }
            seen.add(f);
        }

        return removed;
    }
}
