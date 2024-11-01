package Tries;

public class KthSmallestInLexo {
    public int findKthNumber(int n, int k) {
        int curr = 1;

        while(k > 1) {
            int tot = count(curr, curr+1, n);

            if(tot < k) {
                curr++;
                k -= tot;
            }else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private int count(long curr, long next, int n) {
        int c = 0;

        if(curr <= n) {
            c += (int) (next - curr);
            c += count(curr * 10, Math.min(next * 10, n+1), n);
        }

        return c;
    }
}
