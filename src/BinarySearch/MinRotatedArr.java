package BinarySearch;

public class MinRotatedArr {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minElm = nums[low];

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                minElm = Math.min(nums[low], minElm);
                low = mid + 1;
            }
            else {
                minElm = Math.min(nums[mid], minElm);
                high = mid - 1;
            }
        }

        return minElm;
    }
}
