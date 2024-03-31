package Strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Character c = map.get(s.charAt(i));
            if(c == null){
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
                continue;
            }
            if(c != t.charAt(i)) return false;
        }

        return true;
    }
}
