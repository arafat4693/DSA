package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();

        while(num > 0){
            int idx = 0;

            for(int i = 0; i < vals.length; i++){
                if(num / vals[i] > 0) {
                    idx = i;
                    break;
                }
            }

            res.append(chars[idx].repeat(num / vals[idx]));

            num %= vals[idx];
        }

        return res.toString();
    }
}
