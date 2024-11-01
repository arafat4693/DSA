package DP;

import java.util.Arrays;
import java.util.HashSet;

public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        int[][] cache = new int[stickers.length][(1 << target.length())];

        for(int[] row : cache) Arrays.fill(row, -1);

        int ans = dfs(stickers, target.toCharArray(), 0, 0, cache);
        return ans == Integer.MAX_VALUE/2 ? -1 : ans;
    }

    private int dfs(String[] stickers, char[] target, int idx, int mask,  int[][] cache){
        if(mask == (1 << target.length)-1){
            return 0;
        }
        if(idx == stickers.length) return Integer.MAX_VALUE/2;
        if(cache[idx][mask] != -1) return cache[idx][mask];

        int ans = dfs(stickers, target, idx+1, mask, cache);

        String sticker = stickers[idx];
        int newMask = mask;

        int[] freq = new int[26];
        for(int i = 0; i < sticker.length(); i++) freq[sticker.charAt(i)-'a']++;

        for(int j = 0; j < target.length; j++){
            if((mask & (1 << j)) != 0 || freq[target[j] - 'a'] <= 0){
                continue;
            }
            newMask = (newMask | (1 << j));
            freq[target[j] - 'a']--;
        }

        if(newMask != mask){
            ans = Math.min(ans, 1+dfs(stickers, target, idx, newMask, cache));
        }

        return cache[idx][mask] = ans;
    }
}
