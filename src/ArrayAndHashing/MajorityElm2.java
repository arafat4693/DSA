package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class MajorityElm2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int c1 = 0, m1 = Integer.MAX_VALUE, c2 = 0, m2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (m1 == num) {
                c1++;
            } else if (m2 == num) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                m1 = num;
            } else if (c2 == 0) {
                c2 = 1;
                m2 = num;
            } else {
                c1--;
                c2--;
            }
        }

        int f1 = 0, f2 = 0;

        for(int n : nums){
            if(n == m1) f1++;
            if(n == m2) f2++;
        }

        if(f1 > nums.length/3) res.add(m1);
        if(f2 > nums.length/3) res.add(m2);

        return res;
    }
}
