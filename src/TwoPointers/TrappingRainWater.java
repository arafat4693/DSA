package TwoPointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int totalUnits = 0;
        int maxLeft = height[left];
        int maxRight = height[right];

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                totalUnits += Math.max(maxLeft - height[left], 0);
                maxLeft = Math.max(height[left], maxLeft);
            } else {
                right--;
                totalUnits += Math.max(maxRight - height[right], 0);
                maxRight = Math.max(height[right], maxRight);
            }
        }

        return totalUnits;
    }
}
