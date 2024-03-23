package Strings;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueLength3Palindrom {
    public int countPalindromicSubsequence(String s) {
//        HashSet<Point> res = new HashSet<>();
//        HashMap<Character, Integer> right = new HashMap<>();
//        HashSet<Character> left = new HashSet<>();
//
//        for(int i = 0; i < s.length(); i++) right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0)+1);
//
//        for(int i = 0; i < s.length(); i++){
//            right.put(s.charAt(i), right.get(s.charAt(i))-1);
//            if(right.get(s.charAt(i)) == 0) right.remove(s.charAt(i));
//
//            for(char c = 'a'; c <= 'z'; c++){
//                if(left.contains(c) && right.containsKey(c)) res.add(new Point(c, s.charAt(i)));
//            }
//            left.add(s.charAt(i));
//        }
//
//        return res.size();

        int[] first = new int[26];
        int[] last = new int[26];
        int ans = 0;

        Arrays.fill(first, -1);

        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(first[c] == -1) first[c] = i;
            last[c] = i;
        }

        for(int i = 0; i < 26; i++){
            if(first[i] == -1) continue;
            HashSet<Character> between = new HashSet<>();
            for(int j = first[i]+1; j < last[i]; j++) between.add(s.charAt(j));
            ans += between.size();
        }

        return ans;
    }
}
