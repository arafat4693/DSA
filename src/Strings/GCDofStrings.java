package Strings;

public class GCDofStrings {
    public String gcdOfStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        StringBuilder prefix = new StringBuilder();
        String ans = "";
        for(int i = 0; i < minLength; i++){
            if(str1.charAt(i) != str2.charAt(i)) break;
            prefix.append(str1.charAt(i));

            boolean flag = true;

            for(int j = i+1; j < str1.length(); j += prefix.length()){
                if(j+prefix.length() >= str1.length() || !str1.substring(j, j+prefix.length()).contentEquals(prefix)) {
                    flag = false;
                    break;
                }
            }

            for(int j = i+1; j < str2.length(); j += prefix.length()){
                if(j+prefix.length() >= str2.length() || !str2.substring(j, j+prefix.length()).contentEquals(prefix)) {
                    flag = false;
                    break;
                }
            }

            if(flag) ans = prefix.toString();
        }

        return ans;
    }
}
