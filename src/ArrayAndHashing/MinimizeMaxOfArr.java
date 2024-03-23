package ArrayAndHashing;

public class MinimizeMaxOfArr {
    public int minimizeArrayValue(int[] nums) {
        long res = nums[0];
        long total = nums[0];

        for(int i = 1; i < nums.length; i++){
            total += nums[i];
            res = Math.max(res, (int) Math.ceil((double) total / (i + 1)));
        }

        return (int)res;
    }
}
