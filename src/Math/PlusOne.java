package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();

        int carry = 1;

        for(int i = digits.length-1; i >= 0; i--){
            int r = digits[i] + carry;
            res.add(0, r%10);
            carry = r / 10;
        }

        if(carry != 0) res.add(0, carry);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
