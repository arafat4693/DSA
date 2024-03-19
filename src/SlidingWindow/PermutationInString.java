package SlidingWindow;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Objects;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s2Freq = new int[26];
        int[] s1Freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a'] += 1;
            s2Freq[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;

        for(int i = 0; i < 26; i++){
            matches += (s1Freq[i] == s2Freq[i] ? 1 : 0);
        }

        System.out.println(matches);
        System.out.println("s1: " + Arrays.toString(s1Freq));
        System.out.println("s2: " + Arrays.toString(s2Freq));

        int l = 0;

        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26) return true;
            int currentIdx = s2.charAt(r) - 'a';
            s2Freq[currentIdx] += 1;
            if(s1Freq[currentIdx] == s2Freq[currentIdx]) matches++;
            else if(s1Freq[currentIdx] + 1 == s2Freq[currentIdx]) matches--; //Because of the window shift It's not a match anymore

            int leftIdx = s2.charAt(l) - 'a';
            s2Freq[leftIdx] -= 1;
            if(s2Freq[leftIdx] == s1Freq[leftIdx]) matches++;
            else if(s1Freq[leftIdx] - 1 == s2Freq[leftIdx]) matches--; //Because of the window shift It's not a match anymore
            l++;
        }

//        System.out.println("s1: " + Arrays.toString(s1Freq));
//        System.out.println("s2: " + Arrays.toString(s2Freq));
//        System.out.println("matches: " + matches);

        return matches == 26;
    }
}
