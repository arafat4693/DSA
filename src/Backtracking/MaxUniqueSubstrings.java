package Backtracking;

import java.util.HashSet;

public class MaxUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int idx, HashSet<String> set) {
        int ans = 0;

        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (set.contains(str))
                continue;

            set.add(str);
            ans = Math.max(ans, 1 + backtrack(s, i + 1, set));
            set.remove(str);
        }

        return ans;
    }
}
