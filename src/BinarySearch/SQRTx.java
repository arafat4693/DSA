package BinarySearch;

public class SQRTx {
    public int mySqrt(int x) {
        if(x == 1) return 1;

        long l = 1, r = x / 2, ans = 0;

        while(l <= r){
            long m = (l + r)/2;
            if(m*m == x) return (int)m;
            if(m*m < x){
                l = m + 1;
                ans = m;
            }else r = m - 1;
        }

        return (int)ans;
    }
}
