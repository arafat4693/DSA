package SlidingWindow;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0;
        int l = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){
            if(tMap.get(s.charAt(r)) != null){
                windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0) + 1);
                if(windowMap.get(s.charAt(r)) <= tMap.get(s.charAt(r))) have++;
            }
            while(have == t.length()){
                if((end - start) > (r-l+1)){
                    start = l;
                    end = r+1;
                }
                if(tMap.get(s.charAt(l)) != null){
                    windowMap.put(s.charAt(l), windowMap.getOrDefault(s.charAt(l), 1) - 1);
                    if(windowMap.get(s.charAt(l)) < tMap.get(s.charAt(l))) have--;
                }
                l++;
            }
        }

        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
