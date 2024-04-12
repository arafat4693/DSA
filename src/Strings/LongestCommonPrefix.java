package Strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(String s : strs) minLength = Math.min(minLength, s.length());

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < minLength; i++){
            res.append(strs[0].charAt(i));
            for(String s : strs) {
                if(s.charAt(i) != res.charAt(res.length()-1)){
                    res.deleteCharAt(res.length()-1);
                    return res.toString();
                }
            }
        }

        return res.toString();
    }
}
