package SlidingWindow;

import java.util.HashSet;

public class MaxNrOfVowelsWithK {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int curr = 0, ans = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
            if(vowels.contains(s.charAt(r))) curr++;
            if(r-l+1 != k) continue;

            ans = Math.max(ans, curr);
            curr -= (vowels.contains(s.charAt(l)) ? 1 : 0);
            l++;
        }

        return ans;
    }
}
