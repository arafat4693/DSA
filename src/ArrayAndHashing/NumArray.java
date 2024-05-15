package ArrayAndHashing;

public class NumArray {
    private int[] pSum;
    public NumArray(int[] nums) {
        pSum = new int[nums.length];
        pSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pSum[i] = pSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return pSum[left] + pSum[right] - (left-1 >= 0 ? pSum[left-1] : 0);
    }
}
