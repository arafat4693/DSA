package BitManipulation;

public class CountMaxOrSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int mxOr = 0;

        for (int e : nums)
            mxOr |= e;

        return backtrack(nums, mxOr, 0, 0);
    }

    private int backtrack(int[] nums, int target, int curr, int idx) {
        if (idx == nums.length) {
            if (curr == target)
                return 1;
            return 0;
        }

        int ans = backtrack(nums, target, curr, idx + 1);
        ans += backtrack(nums, target, curr | nums[idx], idx + 1);

        return ans;
    }
}
