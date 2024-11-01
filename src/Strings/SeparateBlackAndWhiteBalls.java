package Strings;

public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int n = s.length(), ones = 0;

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                ones++;
            else
                ans += ones;
        }

        return ans;
    }
}
