package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maximumAmount = 0;

        while(left < right){
            int amount = Math.min(height[left], height[right]) * (right-left);
            maximumAmount = Math.max(amount, maximumAmount);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return maximumAmount;
    }
}
