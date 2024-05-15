package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length-1, carry = 0;
        while(k > 0 && i < num.length){
            int last = k%10;
            num[i] += last+carry;
            carry = num[i]/10;
            num[i] %= 10;
            k /= 10;
            i--;
        }

        List<Integer> res = new ArrayList<>();
        for(int n : num) res.add(n);

        int n = carry+k;
        while(n > 0){
            res.add(0, n%10);
            n /= 10;
        }

        return res;
    }

//    public List<Integer> addToArrayForm(int[] num, int k) {
//        List<Integer> list = new ArrayList<>();
//        int carry = 0;
//        int i = num.length - 1;
//        while(i >= 0 || k > 0 || carry > 0){
//            carry += (i < 0 ? 0 : num[i]) + k % 10;
//            list.add(0, carry % 10);
//            k /= 10;
//            carry /= 10;
//            i--;
//        }
//        return list;
//    }
}
