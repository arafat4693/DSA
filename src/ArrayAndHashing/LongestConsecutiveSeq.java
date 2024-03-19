package ArrayAndHashing;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        int ans = 0;

        for(int n : nums){
            uniqueNums.add(n);
        }

        for(int n : uniqueNums){
            int longest = 0;
            if(!uniqueNums.contains(n-1)){
                while(uniqueNums.contains(n+longest)) longest++;
                ans = Math.max(ans, longest);
            }
        }

        return ans;
    }
}
