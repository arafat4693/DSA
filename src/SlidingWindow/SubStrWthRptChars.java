package SlidingWindow;

import java.util.HashSet;
import java.util.Hashtable;

public class SubStrWthRptChars {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right = 1;
        int longest = 0;

        seen.add(s.charAt(left));

        while(right < s.length()){
            if(seen.contains(s.charAt(right))){
               longest = Math.max(longest, right-left);
               while(s.charAt(left) != s.charAt(right)){
                   seen.remove(s.charAt(left));
                   left++;
               }
               left++;
            }else{
                seen.add(s.charAt(right));
            }
            right++;
        }

        return Math.max(longest, right - left);

//        HashSet<Character> seen = new HashSet<>();
//        int left = 0;
//        int longest = 0;
//
//        for(int r = 0; r < s.length(); r++){
//            if(seen.contains(s.charAt(r))){
//                while(seen.contains(s.charAt(r))){
//                    seen.remove(s.charAt(left));
//                    left++;
//                }
//            }
//
//            seen.add(s.charAt(r));
//            longest = Math.max(longest, r-left+1);
//        }
//        return longest;
    }
}
