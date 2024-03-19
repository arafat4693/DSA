package TwoPointers;

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];

        while(left < right){
            int check = numbers[left] + numbers[right];
            if(check > target) right--;
            else if (check < target) left++;
            else{
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }

        return ans;
    }
}
