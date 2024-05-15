package SlidingWindow;

public class MinimumNumberOfFlipsToMakeBinaryStringAlternating {
    public int minFlips(String s) {
        StringBuilder str = new StringBuilder(s);
        str.append(s);
        StringBuilder zero = new StringBuilder();
        StringBuilder one = new StringBuilder();
        zero.append('0');
        one.append('1');
        for(int i = 1; i < str.length(); i++){
            zero.append(zero.charAt(i-1) == '1' ? '0' : '1');
            one.append(one.charAt(i-1) == '1' ? '0' : '1');
        }

        return Math.min(solve(str, zero), solve(str, one));
    }

    private int solve(StringBuilder str, StringBuilder alt){
        int flips = 0, l = 0, f = 0;

        for(int i = 0; i < str.length(); i++){
            if(i-l+1 <= str.length()/2){
                if(str.charAt(i) != alt.charAt(i)){
                    flips++;
                    f++;
                }
                continue;
            }

            if(str.charAt(l) != alt.charAt(l)) f--;
            if(str.charAt(i) != alt.charAt(i)) f++;
            l++;
            flips = Math.min(flips, f);
        }

        return flips;
    }
}
