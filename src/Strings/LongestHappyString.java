package Strings;

import java.util.*;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();

        PriorityQueue<int[]> maxH = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        if (a != 0)
            maxH.add(new int[] { 0, a });
        if (b != 0)
            maxH.add(new int[] { 1, b });
        if (c != 0)
            maxH.add(new int[] { 2, c });

        while (!maxH.isEmpty()) {
            int[] top = maxH.poll();
            char chr = (char) (top[0] + 'a');
            int s = ans.length();

            if (ans.length() >= 2 && ans.charAt(s - 1) == chr && ans.charAt(s - 2) == chr) {
                if (maxH.isEmpty())
                    break;
                int[] nextTop = maxH.poll();
                ans.append((char) (nextTop[0] + 'a'));
                nextTop[1]--;
                if (nextTop[1] != 0)
                    maxH.add(nextTop);
                maxH.add(top);
            } else {
                ans.append(chr);
                top[1]--;
                if (top[1] != 0)
                    maxH.add(top);
            }
        }

        return ans.toString();
    }
}
