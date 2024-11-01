package DP;

import java.util.*;

public class MaxValueSumByPlacing3Rooks2 {
    public long maximumValueSum(int[][] board) {
        int rows = board.length, cols = board[0].length;

        int[][] maxAbove = new int[rows][cols];
        int[][] maxBelow = new int[rows][cols];

        int[][][] maxAboveTop3Cols = new int[rows][3][2];
        int[][][] maxBelowTop3Cols = new int[rows][3][2];
        int[][][] boardTop3Cols = new int[rows][3][2];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int mx = i == 0 ? board[i][j] : Math.max(board[i][j], maxAbove[i-1][j]);
                maxAbove[i][j] = mx;
            }
            maxAboveTop3Cols[i] = top3Cols(maxAbove[i]);
        }

        for(int i = rows-1; i >= 0; i--) {
            for(int j = 0; j < cols; j++) {
                int mx = i == rows-1 ? board[i][j] : Math.max(board[i][j], maxBelow[i+1][j]);
                maxBelow[i][j] = mx;
            }
            maxBelowTop3Cols[i] = top3Cols(maxBelow[i]);
        }

        for(int i = 0; i < rows; i++) {
            boardTop3Cols[i] = top3Cols(board[i]);
        }

        // System.out.println(Arrays.deepToString(maxAbove));
        // System.out.println(Arrays.deepToString(maxBelow));

        long points = Long.MIN_VALUE;

        for(int i = 1; i < rows-1; i++) {
            // int[][] pre = top3Cols(maxAbove[i-1]);
            // int[][] mid = top3Cols(board[i]);
            // int[][] suff = top3Cols(maxBelow[i+1]);

            int[][] pre = maxAboveTop3Cols[i-1];
            int[][] mid = boardTop3Cols[i];
            int[][] suff = maxBelowTop3Cols[i+1];

            for(int[] m : mid) {
                for(int[] p : pre) {
                    for(int[] s : suff) {
                        if(p[1] != m[1] && p[1] != s[1] && s[1] != m[1]) {
                            points = Math.max(points, (long)p[0]+m[0]+s[0]);
                        }
                    }
                }
            }
        }

        return points;
    }

    private int[][] top3Cols(int[] row) {
        int[][] tmp = new int[row.length][2];

        for(int k = 0; k < row.length; k++) tmp[k] = new int[]{row[k], k};
        Arrays.sort(tmp, (a, b) -> b[0] - a[0]);

        int[][] nTmp = new int[3][2];
        nTmp[0] = tmp[0];
        nTmp[1] = tmp[1];
        nTmp[2] = tmp[2];

        return nTmp;
    }

    // private long solve(int idx, int rem, int c1, int c2, long[][][][] cache) {
    //     if(rem == 3) return 0;
    //     if(idx == newBoard.length) return Long.MIN_VALUE/2;
    //     if(cache[idx][rem][c1+1][c2+1] != Long.MAX_VALUE) return cache[idx][rem][c1+1][c2+1];

    //     long points = solve(idx+1, rem, c1, c2, cache);

    //     for(int[] row : newBoard[idx]) {
    //         if(row[1] == c1 || row[1] == c2) continue;

    //         if(c1 == -1) {
    //             points = Math.max(points, row[0] + solve(idx+1, rem+1, row[1], c2, cache));
    //         }else if(c2 == -1) {
    //             points = Math.max(points, row[0] + solve(idx+1, rem+1, c1, row[1], cache));
    //         } else points = Math.max(points, row[0] + solve(idx+1, rem+1, c1, c2, cache));
    //     }

    //     return cache[idx][rem][c1+1][c2+1] = points;
    // }
}
