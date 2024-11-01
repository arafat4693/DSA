package DP;

import java.util.*;

public class ConcatenetedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
        HashMap<String, Boolean> cache = new HashMap<>();
        // System.out.println(wordsSet);
        List<String> res = new ArrayList<>();

        for(String word : words){
            if(solve(wordsSet, word, cache)) res.add(word);
            // System.out.println(cache);
        }

        return res;
    }

    private boolean solve(HashSet<String> set, String word, HashMap<String, Boolean> cache){
        if(cache.containsKey(word)) return cache.get(word);

        boolean ans = false;

        for(int i = 0; i < word.length(); i++){
            String prefix = word.substring(0, i+1), suffix = word.substring(i+1);

            if(!set.contains(prefix)) continue;

            if(set.contains(suffix)) {
                ans = true;
                break;
            }

            ans = solve(set, suffix, cache);
            if(ans) break;
        }

        cache.put(word, ans);

        return ans;
    }
}
