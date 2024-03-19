package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) return true;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String newS = builder.toString();
        for(int i = 0; i<newS.length()/2; i++){
            if(newS.charAt(i) != newS.charAt(newS.length()-1-i)) return false;
        }

        return true;
    }
}
