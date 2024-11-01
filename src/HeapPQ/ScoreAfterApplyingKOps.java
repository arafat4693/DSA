package HeapPQ;

import java.util.*;

public class ScoreAfterApplyingKOps {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);
        long score = 0;

        for (int n : nums)
            maxH.add(n);

        while (k > 0) {
            int top = maxH.poll();
            int newTop = (int) Math.ceil((double) top / 3);

            score += top;

            maxH.add(newTop);

            k--;
        }

        return score;
    }
}
