package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> hashtable = new Hashtable<>();

        for(String s : strs){
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String mKey = new String(sArr);
            if(!hashtable.containsKey(mKey)){
                hashtable.put(mKey, new ArrayList<>());
            }
            hashtable.get(mKey).add(s);
        }

        return new ArrayList<>(hashtable.values());
    }
}
