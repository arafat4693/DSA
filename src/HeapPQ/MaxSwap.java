package HeapPQ;

import java.util.PriorityQueue;

public class MaxSwap {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        for (int i = 0; i < n; i++)
            maxH.add(new int[] { arr[i] - 'a', i });

        for (int i = 0; i < n; i++) {
            int[] top = maxH.poll();
            char chr = (char) (top[0] + 'a');

            if (top[0] > arr[i] - 'a') {
                int idx = top[1];
                while (!maxH.isEmpty() && maxH.peek()[0] == top[0]) {
                    idx = maxH.poll()[1];
                }
                arr[idx] = arr[i];
                arr[i] = chr;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(arr));
    }
}
