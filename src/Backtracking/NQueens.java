package Backtracking;

import java.util.*;

public class NQueens {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//        HashSet<Integer> cols = new LinkedHashSet<>();
//        HashSet<Integer> pD = new LinkedHashSet<>();
//        HashSet<Integer> nD = new LinkedHashSet<>();
//        dfs(n, res, cols, pD, nD, 0);
//        return res;
//    }
//
//    private void dfs(int n, List<List<String>> res, HashSet<Integer> cols, HashSet<Integer> pD, HashSet<Integer> nD, int rowIdx){
//        if(rowIdx >= n){
//            List<String> subRes = new ArrayList<>();
//            for(int c : cols){
//                subRes.add(".".repeat(c) + "Q" + ".".repeat(n-c-1));
//            }
//            res.add(subRes);
//            return;
//        }
//
//        for(int col = 0; col < n; col++){
//            boolean r = cols.contains(col) || pD.contains(rowIdx + col) || nD.contains(rowIdx - col);
//            if(r) continue;
//
//            cols.add(col);
//            pD.add(rowIdx + col);
//            nD.add(rowIdx - col);
//
//            dfs(n, res, cols, pD, nD, rowIdx + 1);
//
//            cols.remove(col);
//            pD.remove(rowIdx + col);
//            nD.remove(rowIdx - col);
//        }
//    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        HashSet<Integer> cols = new LinkedHashSet<>();
        HashSet<Integer> pD = new LinkedHashSet<>();
        HashSet<Integer> nD = new LinkedHashSet<>();
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(n, res, cols, pD, nD, 0, board);
        return res;
    }

    private void dfs(int n, List<List<String>> res, HashSet<Integer> cols, HashSet<Integer> pD, HashSet<Integer> nD, int rowIdx, char[][] board){
        if(rowIdx >= n){
            List<String> subRes = new ArrayList<>();
            for(char[] row : board) {
                subRes.add(new String(row));
            }
            res.add(subRes);
            return;
        }

        for(int col = 0; col < n; col++){
            boolean r = cols.contains(col) || pD.contains(rowIdx + col) || nD.contains(rowIdx - col);
            if(r) continue;

            cols.add(col);
            pD.add(rowIdx + col);
            nD.add(rowIdx - col);
            board[rowIdx][col] = 'Q';

            dfs(n, res, cols, pD, nD, rowIdx + 1, board);

            cols.remove(col);
            pD.remove(rowIdx + col);
            nD.remove(rowIdx - col);
            board[rowIdx][col] = '.';
        }
    }
}
