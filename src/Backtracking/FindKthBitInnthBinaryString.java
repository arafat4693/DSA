package Backtracking;

public class FindKthBitInnthBinaryString {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';

        int half = ((1 << n) - 1) / 2;
        k--;

        if (half == k)
            return '1';

        String s = genStr(n - 1, 1, "0");

        if (k < half)
            return s.charAt(k);

        String rev = reverseInverse(s);
        half++;

        return rev.charAt(k - half);
    }

    private String reverseInverse(String str) {
        StringBuilder invert = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            invert.append(str.charAt(i) == '0' ? '1' : '0');
        }

        StringBuilder revInv = new StringBuilder();
        revInv.append(invert);
        revInv.reverse();

        return revInv.toString();
    }

    private String genStr(int targetLvl, int currLvl, String str) {
        if (targetLvl == currLvl)
            return str;

        StringBuilder newStr = new StringBuilder();
        newStr.append(str).append(1).append(reverseInverse(str));

        return genStr(targetLvl, currLvl + 1, newStr.toString());
    }
}
