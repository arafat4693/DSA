package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestUnoccufiedChairs {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[][] all = new int[n][3];

        for (int i = 0; i < n; i++) {
            all[i] = new int[] { times[i][0], times[i][1], i }; // arr, lev, idx
        }

        Arrays.sort(all, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minC = new PriorityQueue<>((a, b) -> a - b);

        minH.add(new int[] { all[0][1], 0 });

        int mxC = 0;

        for (int i = 1; i < n; i++) {
            int[] top = minH.peek();
            int[] curr = all[i];

            while (!minH.isEmpty() && minH.peek()[0] <= curr[0])
                minC.add(minH.poll()[1]);

            if (minC.isEmpty())
                minC.add(++mxC);

            int chair = minC.poll();
            minH.add(new int[] { curr[1], chair });

            if (curr[2] == targetFriend)
                return chair;
        }

        return 0;
    }
}
