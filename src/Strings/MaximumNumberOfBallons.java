package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumNumberOfBallons {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashSet<Character> b = new HashSet<>();
        String balloon = "balloon";

        for(int i = 0; i < balloon.length(); i++) b.add(balloon.charAt(i));

        for(int i = 0; i < text.length(); i++){
            if(b.contains(text.charAt(i))) freq.put(text.charAt(i), freq.getOrDefault(text.charAt(i), 0)+1);
        }

        if(freq.size() < 5) return 0;

        int count = Integer.MAX_VALUE;

        for(char k : freq.keySet()){
            if(k == 'l' || k == 'o') count = Math.min(count, freq.get(k)/2);
            count = Math.min(count, freq.get(k));
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
