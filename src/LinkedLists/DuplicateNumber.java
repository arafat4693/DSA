package LinkedLists;

public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[nums[slow]];
            fast = nums[nums[nums[fast]]];
        } while (slow != fast);

//        System.out.println("slow: " + slow);
//        System.out.println("fast: " + fast);
        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];

            System.out.println("slow: " + slow);
            System.out.println("fast: " + fast);
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
