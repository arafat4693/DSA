package Backtracking;

import java.util.Arrays;

public class WordSearch {
//    public boolean exist(char[][] board, String word) {
//        boolean[][] seen = new boolean[board.length][board[0].length];
//
//        for( int row = 0; row < board.length; row++ ){
//            for(int col = 0; col < board[0].length; col++){
//                if(dfs(row, col, seen, board, word, "")) return true;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean dfs(int row, int col, boolean[][] seen, char[][] board, String word, String result){
//        seen[row][col] = true;
//        result += board[row][col];
//
//        if(word.length() == result.length()){
//            seen[row][col] = false;
//            return word.equals(result);
//        }
//
//        // right
//        if((col + 1) < board[0].length && !seen[row][col+1]){
//            if(dfs(row, col+1, seen, board, word, result)) return true;
//        }
//        // left
//        if((col - 1) >= 0 && !seen[row][col-1]){
//            if(dfs(row, col-1, seen, board, word, result)) return true;
//        }
//        // down
//        if((row + 1) < board.length && !seen[row+1][col]){
//            if(dfs(row+1, col, seen, board, word, result)) return true;
//        }
//        // up
//        if((row - 1) >= 0 && !seen[row-1][col]){
//            if(dfs(row-1, col, seen, board, word, result)) return true;
//        }
//
//        seen[row][col] = false;
//        return false;
//    }

    public boolean exist(char[][] board, String word) {
        for( int row = 0; row < board.length; row++ ){
            for(int col = 0; col < board[0].length; col++){
                if(dfs(row, col, board, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int index){
        if(index == word.length()) return true;
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#';
        boolean result = dfs(row, col+1, board, word, index+1) ||
                         dfs(row, col-1, board, word, index+1) ||
                         dfs(row+1, col, board, word, index+1) ||
                         dfs(row-1, col, board, word, index+1);

        board[row][col] = temp;
        return result;
    }
}

