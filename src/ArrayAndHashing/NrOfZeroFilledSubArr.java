package ArrayAndHashing;

public class NrOfZeroFilledSubArr {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, streak = 0;

        for(int n : nums){
            if(n != 0) streak = 0;
            else {
                streak++;
                res += streak;
            }
        }

        return res;
    }
}
