package BinarySearch;

public class SrcRotatedArr {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(target == nums[mid]) return mid;

            // left sored side
            if(nums[low] <= nums[mid]){
                if(target > nums[mid] || nums[low] > target ){
                    low = mid + 1;
                }else high = mid - 1;
            }else {
                if(target < nums[mid] || target > nums[high]){
                    high = mid - 1;
                }else low = mid + 1;
            }
        }

        return -1;
    }
}
