package Math;

import java.util.Arrays;

public class FindMissingObservation {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = ((rolls.length+n)*mean) - Arrays.stream(rolls).sum();

        if(sum > n*6 || sum < n) return new int[]{};

        int[] res = new int[n];

        int idx = 0;

        while(sum != 0){
            int dice = Math.min(sum - n + 1, 6);
            res[idx++] = dice;
            sum -= dice;
            n -= 1;
        }

        return res;
    }
}
