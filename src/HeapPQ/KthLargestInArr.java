package HeapPQ;

import java.util.PriorityQueue;

public class KthLargestInArr {
    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        for(int n : nums) pq.add(n);
//        while(k != 1){
//            pq.poll();
//            k--;
//        }
//        return pq.poll();
        k = nums.length - k;
        return quickSelect(0, nums.length - 1, nums, k);
    }

    private int quickSelect(int l, int r, int[] nums, int k){
        int pivot = nums[r], p = l;

        for(int i = l; i < r; i++){
            if(nums[i] <= pivot) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, r);

        if(p > k) return quickSelect(0, p-1, nums, k);
        else if(p < k) return quickSelect(p+1, r, nums, k);
        else return nums[p];
    }

    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
