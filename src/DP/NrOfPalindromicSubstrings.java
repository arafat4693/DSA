package DP;

public class NrOfPalindromicSubstrings {
    int total = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            // odd
            palin(i, i, s);
            // even
            palin(i, i+1, s);
        }
        return total;
    }

    private void palin(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            total++;
            l--;
            r++;
        }
    }
}
