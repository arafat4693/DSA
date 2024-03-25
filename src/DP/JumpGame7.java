package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
//        if(s.charAt(s.length() - 1) == '1') return false;

//        int[] cache = new int[s.length()];
//        Arrays.fill(cache, -1);
//
//        int count = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == '1'){
//                count++;
//                if(count >= maxJump) return false;
//            }
//            else count = 0;
//        }
//
//        return dfs(s, minJump, maxJump, 0, cache) == 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int farthest = 0;

        while(!q.isEmpty()){
            int i = q.poll();
            int start = Math.max(i + minJump, farthest+1);
            for(int j = start; j <= Math.min(i+maxJump, s.length()-1); j++){
                if(s.charAt(j) == '0'){
                    q.add(j);
                    if (j == s.length()-1) return true;
                }
            }
            farthest = i+maxJump;
        }

        return false;
    }

    private int dfs(String s, int minJump, int maxJump, int idx, int[] cache){
        if(idx >= s.length() || s.charAt(idx) == '1') return 0;
        if(idx == s.length()-1) return 1;
        if(cache[idx] != -1) return cache[idx];

        int ans = 0;

        for(int i = minJump; i <= maxJump; i++){
            ans = dfs(s, minJump, maxJump, idx+i, cache);
            if(ans == 1) break;
        }

        return cache[idx] = ans;
    }
}
