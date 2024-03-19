package BitManipulation;

public class CountingBits {
    public int[] countBits(int n) {
//        int[] ans = new int[n+1];
//
//        for(int i = 0; i <= n; i++){
//            int oneBits = 0;
//            int m = i;
//            while(m != 0){
//                m = m & (m-1);
//                oneBits++;
//            }
//            ans[i] = oneBits;
//        }
//
//        return ans;

        int[] dp = new int[n+1];
        int offset = 1;
        for(int i = 1; i <= n; i++){
            if(offset * 2 == i) offset = i;
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}
