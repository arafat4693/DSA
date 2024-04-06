package Greedy;

public class MinSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        int extra = 0, mx = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']') extra++;
            else extra--;
            mx = Math.max(mx, extra);
        }

        return (mx+1)/2;
    }
}
