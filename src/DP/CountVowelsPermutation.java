package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountVowelsPermutation {
    int mod = 1000000007;
    public int countVowelPermutation(int n) {
        HashMap<Character, Character[]> adj = new HashMap<>();
        long[][] cache = new long[n+1][26];

        for(long[] row : cache) Arrays.fill(row, -1);

        adj.put('a', new Character[]{'e'});
        adj.put('e', new Character[]{'a', 'i'});
        adj.put('i', new Character[]{'a', 'e', 'o', 'u'});
        adj.put('o', new Character[]{'i', 'u'});
        adj.put('u', new Character[]{'a'});

        long total = 0;

        for(char k : adj.keySet()) total += dfs(k, n, adj, cache);

        return (int) (total%mod);
    }

    private long dfs(char vowel, int n, HashMap<Character, Character[]> adj, long[][] cache){
        if(n == 1) return 1;
        if(cache[n][vowel-'a'] != -1) return cache[n][vowel-'a'];

        long ans = 0;

        for(Character c : adj.get(vowel)){
            long res = dfs(c, n-1, adj, cache);
            ans += res;
            ans %= mod;
        }

        return cache[n][vowel-'a'] = ans;
    }
}
