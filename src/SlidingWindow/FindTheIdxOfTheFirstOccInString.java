package SlidingWindow;

public class FindTheIdxOfTheFirstOccInString {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        StringBuilder str = new StringBuilder();
        int l = 0, m = 0;
        for(int i = 0; i < haystack.length(); i++){
            str.append(haystack.charAt(i));
            if(i-l+1 < needle.length()){
                continue;
            }
            if(str.toString().equals(needle)) return l;
            str.deleteCharAt(0);
            l++;
        }

        return -1;
    }
}
