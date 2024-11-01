package DP;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] cache = new int[key.length()][ring.length()];
        return dfs2(ring, key, 0, 0, cache);
    }

    private int dfs(String ring, String key, int ki, int ri, int[][] cache){
        if(ki == key.length()) return 0;
        if(cache[ki][ri] != 0) return cache[ki][ri];

        char code = key.charAt(ki);

        int i1 = ri, t1 = 1;
        while(ring.charAt(i1) != code){
            i1++;
            t1++;
            if(i1 == ring.length()) i1 %= ring.length();
        }

        int i2 = ri, t2 = 1;
        while(ring.charAt(i2) != code){
            i2--;
            t2++;
            if(i2 < 0) i2 = ring.length()-1;
        }

        int time = Math.min(t1+dfs(ring, key, ki+1, i1, cache), t2+dfs(ring, key, ki+1, i2, cache));

        return cache[ki][ri] = time;
    }

    private int dfs2(String ring, String key, int ki, int ri, int[][] cache){
        if(ki == key.length()) return 0;
        if(cache[ki][ri] != 0) return cache[ki][ri];

        char code = key.charAt(ki);
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == code) {
                int steps = countSteps(ri, i, ring.length());
                res = Math.min(res, steps + dfs2(ring, key, ki+1, i, cache));
            }
        }

        return cache[ki][ri] = res;
    }

    private int countSteps(int ringIndex, int i, int length){
        int distance = Math.abs(i - ringIndex);
        int wrapAround = length - distance;
        return Math.min(distance, wrapAround) + 1;
    }
}
