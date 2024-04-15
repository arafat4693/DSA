package ArrayAndHashing;

public class ShuffleTheArray {
    // public int[] shuffle(int[] nums, int n) {
    //     int[] res = new int[2*n];

    //     int idx = 0;

    //     for(int i = 0; i < 2*n; i+=2){
    //         res[i] = nums[idx++];
    //     }

    //     for(int i = 1; i < 2*n; i+=2){
    //         res[i] = nums[idx++];
    //     }

    //     return res;
    // }

//    public int[] shuffle(int[] nums, int n) {
//        int[] res = new int[2*n];
//        for(int i=0;i<n;i++){
//            res[2*i]=nums[i];
//            res[2*i+1]=nums[n+i];
//        }
//        return res;
//    }

    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++){
            nums[i] = ((nums[i] << 10) | nums[i+n]);
        }

        int idx = nums.length-1;

        for(int i = n-1; i >= 0; i--){
            int y = nums[i] & 1023;
            nums[i] = nums[i] >>> 10;

            nums[idx] = y;
            nums[idx-1] = nums[i];
            idx-=2;
        }

        return nums;
    }
}
