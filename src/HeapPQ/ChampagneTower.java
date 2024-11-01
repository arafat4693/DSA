package HeapPQ;

import java.util.Arrays;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cache = new double[query_row+1][query_glass+1];
        for(double[] row : cache) Arrays.fill(row, -1);

        double ans = dfs(poured, query_row, query_glass, cache);
        return ans > 1 ? 1 : ans;
    }

    private double dfs(int poured, int row, int glass, double[][] cache){
        if(glass > row || row < 0 || glass < 0) return 0;
        if(row == 0 && glass == 0) return (double) poured;
        if(cache[row][glass] != -1) return cache[row][glass];

        double left = (dfs(poured, row-1, glass-1, cache) - 1)/2;
        double right = (dfs(poured, row-1, glass, cache) - 1) / 2;

        if(left < 0) left = 0;
        if(right < 0) right = 0;

        return cache[row][glass] = left + right;
    }
}
