package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
//        Arrays.sort(nums, (a, b) -> {
//            if(a.length() != b.length()) return a.length() - b.length();
//            return a.compareTo(b);
//        });

        // System.out.println(Arrays.toString(nums));
        // PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
        //     if(a.length() != b.length()) return a.length() - b.length();
        //     for(int i = 0; i < a.length(); i++){
        //         if(a.charAt(i) < b.charAt(i)) return -1;
        //         else if(a.charAt(i) > b.charAt(i)) return 1;
        //     }
        //     return 0;
        // });

        // for(String num : nums) {
        //     pq.add(num);
        //     if(pq.size() > k) pq.poll();
        // }
        // return pq.poll();

//        return nums[nums.length-k];

        return quickSelect(0, nums.length-1, nums, k);
    }

    private String quickSelect(int l, int r, String[] nums, int k){
        int p = l;

        for(int i = l; i < r; i++){
            if(cs(nums[i], nums[r]) <= 0){
                String tmp = nums[p];
                nums[p++] = nums[i];
                nums[i] = tmp;
            }
        }

        String tmp = nums[p];
        nums[p] = nums[r];
        nums[r] = tmp;

        if(p == nums.length-k) return nums[p];
        if(p < nums.length-k) return quickSelect(p+1, r, nums, k);
        return quickSelect(l, p-1, nums, k);
    }

    private int cs(String a, String b){
        if(a.length() != b.length()) return a.length() - b.length();
        return a.compareTo(b);
    }
}
