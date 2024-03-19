package Math;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] res = new int[num1.length() + num2.length()];

        for(int i1 = 0; i1 < num1.length(); i1++){
            for(int i2 = 0; i2 < num2.length(); i2++){
                res[i1+i2] += (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                res[i1+i2+1] = res[i1+i2] / 10;
                res[i1+i2] = res[i1+i2] % 10;
            }
        }

        reverseArray(res);
        int beg = 0;
        while(beg < res.length && res[beg] == 0) beg++;

        StringBuilder output = new StringBuilder();
        for(int i = beg; i < res.length; i++) output.append(res[i]);
        return output.toString();
    }

    public void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
