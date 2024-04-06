package SlidingWindow;

import java.util.HashSet;

public class CntIfStrContainsBinCodeSizeK {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> bin = new HashSet<>();

        int total = (int) Math.pow(2, k);

        StringBuilder res = new StringBuilder();
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            res.append(s.charAt(r));
            if(r-l+1 != k) continue;
            bin.add(res.toString());
            if(bin.size() == total) return true;
            System.out.println(res);
            res.deleteCharAt(0);
            l++;
        }

        return false;
    }
}
