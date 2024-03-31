package ArrayAndHashing;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int elm = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                elm = nums[i];
                count = 1;
                continue;
            }

            if(nums[i] != elm) count--;
            else count++;
        }

        return elm;
    }
}
