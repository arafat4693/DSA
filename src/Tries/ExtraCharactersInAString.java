package Tries;

import java.util.Arrays;

public class ExtraCharactersInAString {
    TrieNode root = new TrieNode();
    public int minExtraChar(String s, String[] dictionary) {
        insertWords(root, dictionary);

        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(s, 0, cache);
    }

    private int dfs(String s, int idx, int[] cache){
        if(idx >= s.length()) return 0;
        if(cache[idx] != -1) return cache[idx];

        int res = 1 + dfs(s, idx+1, cache);

        TrieNode curr = root;

        for(int j = idx; j < s.length(); j++){
            if(!curr.children.containsKey(s.charAt(j))) break;
            curr = curr.children.get(s.charAt(j));
            if(curr.isEndOfWord){
                res = Math.min(res, dfs(s, j+1, cache));
            }
        }

        return cache[idx] = res;
    }

    private void insertWords(TrieNode root, String[] dict){
        for(String d : dict){
            TrieNode curr = root;
            for(int i = 0; i < d.length(); i++){
                if(!curr.children.containsKey(d.charAt(i))) curr.children.put(d.charAt(i), new TrieNode());
                curr = curr.children.get(d.charAt(i));
            }
            curr.isEndOfWord = true;
        }
    }

    private boolean searchWord(TrieNode root, String word, int lb, int ub){
        TrieNode curr = root;

        for(int i = lb; i < ub; i++){
            if(i >= word.length() || !curr.children.containsKey(word.charAt(i))) return false;
            curr = curr.children.get(word.charAt(i));
        }

        return curr.isEndOfWord;
    }
}
