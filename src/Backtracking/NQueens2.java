package Backtracking;

import java.util.HashSet;

public class NQueens2 {
    public int totalNQueens(int n) {
        HashSet<Integer> column = new HashSet<>();
        HashSet<Integer> rightDiagonal = new HashSet<>();
        HashSet<Integer> leftDiagonal = new HashSet<>();
        return backtrack(column, rightDiagonal, leftDiagonal, n, 0);
    }

    private int backtrack(HashSet<Integer> column, HashSet<Integer> rightDiagonal, HashSet<Integer> leftDiagonal, int n, int row){
        if(row == n) return 1;

        int ans = 0;

        for(int i = 0; i < n; i++){
            if(column.contains(i) || rightDiagonal.contains(i-row) || leftDiagonal.contains(n-row-i)) continue;

            column.add(i);
            rightDiagonal.add(i-row);
            leftDiagonal.add(n-row-i);

            ans += backtrack(column, rightDiagonal, leftDiagonal, n, row+1);

            column.remove(i);
            rightDiagonal.remove(i-row);
            leftDiagonal.remove(n-row-i);
        }

        return ans;
    }
}
