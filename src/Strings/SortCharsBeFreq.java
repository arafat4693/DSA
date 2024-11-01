package Strings;

import java.util.*;

public class SortCharsBeFreq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

        HashMap<Integer, List<Character>> bucket = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            int f = freq.get(s.charAt(i));
            bucket.putIfAbsent(f, new ArrayList<>());

            bucket.get(f).add(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        for(int i = s.length(); i >= 1; i--){
            if(!bucket.containsKey(i)) continue;

            Collections.sort(bucket.get(i));

            for(char c : bucket.get(i)) res.append(c);
        }

        return res.toString();
    }
}
