package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> cache = new HashMap<>();
//        return dfs(cache, s, wordDict);

        for(int j = s.length() - 1; j >= 0; j--){
            String curString = s.substring(j);
            for(int i = 0; i < wordDict.size(); i++){
                if(wordDict.get(i).length() > curString.length() || !curString.startsWith(wordDict.get(i))) continue;

                String restOfString = s.substring(wordDict.get(i).length()+j);
                if(restOfString.isEmpty() || (cache.containsKey(restOfString) && cache.get(restOfString))){
                    cache.put(curString, true);
                    break;
                }
            }
            cache.putIfAbsent(curString, false);
        }

//        System.out.println(cache);

        return cache.get(s);
    }

    private boolean dfs(HashMap<String, Boolean> cache, String s, List<String> wordDict){
        if(s.isEmpty()) return true;
        if(cache.containsKey(s)) return cache.get(s);

        for(int i = 0; i < wordDict.size(); i++){
            if(wordDict.get(i).length() > s.length() || !s.startsWith(wordDict.get(i))) continue;

            if(dfs(cache, s.substring(wordDict.get(i).length()), wordDict)){
                cache.put(s, true);
                return true;
            }

        }

        cache.put(s, false);
        return false;
    }
}
