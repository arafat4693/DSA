package TwoPointers;

public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        int[] mx = new int[n];
        mx[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            mx[i] = Math.max(mx[i + 1], nums[i]);
        }

        int i = 0, j = 0, ans = 0;

        while (j < n && i < n) {
            if (mx[j] < nums[i])
                i++;
            else {
                ans = Math.max(ans, j - i);
                j++;
            }
        }

        return ans;
    }
}
