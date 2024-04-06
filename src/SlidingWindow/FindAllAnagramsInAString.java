package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < p.length(); i++) pArr[p.charAt(i)-'a']++;

        int l = 0;

        for(int r = 0; r < s.length(); r++){
            sArr[s.charAt(r)-'a']++;

            if(r-l+1 != p.length()) continue;

            if(Arrays.equals(sArr, pArr)) res.add(l);
            sArr[s.charAt(l)-'a']--;
            l++;
        }

        return res;
    }
}
