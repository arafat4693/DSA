package ArrayAndHashing;

public class CountSubStringsThatSutisfiesK2 {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length(), q = queries.length, l = 0, ones = 0;
        long[] res = new long[q];

        int[] end = new int[n];

        for(int r = 0; r < n; r++) {
            if(s.charAt(r) == '1') ones++;

            while((r-l+1)-ones > k && ones > k) {
                if(s.charAt(l) == '1') ones--;
                l++;
            }

            end[r] = r-l+1;
        }

        long[] cumEnd = new long[n];
        cumEnd[0] = end[0];
        for(int i = 1; i < n; i++) cumEnd[i] = cumEnd[i-1] + end[i];

        int[] validTo = new int[n];
        l = n-1;
        ones = 0;
        for(int r = n-1; r >= 0; r--) {
            if(s.charAt(r) == '1') ones++;

            while((l-r+1)-ones > k && ones > k) {
                if(s.charAt(l) == '1') ones--;
                l--;
            }

            validTo[r] = l;
        }

        // System.out.println(Arrays.toString(cumEnd));
        // System.out.println(Arrays.toString(validTo));

        for(int i = 0; i < q; i++) {
            int[] query = queries[i];
            int low = query[0], high = query[1];

            int validRightIdx = Math.min(validTo[low], high);
            int len = validRightIdx - low + 1;

            long result = ((long) len *(len+1)) / 2;
            long leftOut = cumEnd[high] - cumEnd[validRightIdx];

            result += leftOut;

            res[i] = result;
        }

        return res;
    }
}
