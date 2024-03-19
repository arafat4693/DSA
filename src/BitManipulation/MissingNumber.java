package BitManipulation;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // a xor a = 0
        // o xor 0 = a
        // a xor b xor c xor a = b xor c

        int res = 0;
        for(int n : nums) res = res ^ n;

        for(int i = 0; i <= nums.length; i++){
            res = res ^ i;
        }

        return res;
    }
}
