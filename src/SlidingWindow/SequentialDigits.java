package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String nums = "123456789";
        int len = Integer.toString(low).length();

        List<Integer> ans = new ArrayList<>();

        while(len <= nums.length()){
            int left = 0;
            boolean flag = false;

            for(int right = len-1; right < nums.length(); right++){
                int num = Integer.parseInt(nums.substring(left, right+1));
                if(num >= low && num <= high) ans.add(num);
                else if(num > high){
                    flag = true;
                    break;
                }
                left++;
            }

            if(flag) break;
            else len++;
        }

        return ans;
    }
}
