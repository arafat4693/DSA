package ArrayAndHashing;

import java.util.Arrays;

public class RankTransformArr {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[][] res = new int[n][2];
        int[] ans = new int[n];

        if (n == 0)
            return ans;

        for (int i = 0; i < n; i++)
            res[i] = new int[] { arr[i], i };

        Arrays.sort(res, (a, b) -> a[0] - b[0]);

        ans[res[0][1]] = 1;

        for (int i = 1; i < n; i++) {
            if (res[i][0] == res[i - 1][0])
                ans[res[i][1]] = ans[res[i - 1][1]];
            else
                ans[res[i][1]] = ans[res[i - 1][1]] + 1;
        }

        return ans;
    }
}
