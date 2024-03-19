package SlidingWindow;

import java.util.HashMap;

public class LongstRptngCharsReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int longest = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            int mostFreq = 0;
            for(char c : freq.keySet()){
                mostFreq = Math.max(freq.get(c), mostFreq);
            }
            while((r-l+1) - mostFreq > k){
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 1) - 1);
                l++;
            }

            longest = Math.max(longest, r-l+1);
            r++;
        }

        return longest;
    }
}
