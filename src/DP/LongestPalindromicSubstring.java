package DP;

public class LongestPalindromicSubstring {
    String res = "";
    int resLength = 0;

    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            // odd length
            getPalin(i, i, s);
            // even length
            getPalin(i, i+1, s);
        }
        return res;
    }

    private void getPalin(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > resLength){
                resLength = r-l+1;
                res = s.substring(l, r+1);
            }
            l--;
            r++;
        }
    }
}
