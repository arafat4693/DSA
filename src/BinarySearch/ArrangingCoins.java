package BinarySearch;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        int rows = 0;

        while(l <= r){
            long m = (l+r)/2;
            long total = (m/2)*(m+1); // gauss
            if(m % 2 != 0) total += (m/2)+1;
            if(total == n) return (int)m;
            if(total < n) l = m+1;
            else {
                r = m-1;
                rows = (int)m;
            }
        }

        return rows-1;
    }
}
