package BinarySearch;

import java.util.HashSet;

public class MaximumNumberOfRemovalChars {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length-1, ans = 0;

        while(l <= r){
            int m = (l+r)/2;

            HashSet<Integer> removed = new HashSet<>();
            for(int i = 0; i <= m; i++) removed.add(removable[i]);

            if(isSubSeq(s, p, removed)){
                ans = m+1;
                l = m+1;
            }else r = m-1;
        }

        return ans;
    }

    private boolean isSubSeq(String s, String p, HashSet<Integer> removed){
        int si = 0, pi = 0;

        while(si < s.length() && pi < p.length()){
            if(removed.contains(si) || s.charAt(si) != p.charAt(pi)){
                si++;
            }else {
                si++;
                pi++;
            }
        }

        return pi == p.length();
    }
}
