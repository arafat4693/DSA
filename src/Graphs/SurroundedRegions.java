package Graphs;

public class SurroundedRegions {
    public static void solve(char[][] board) {
       for(int row = 0; row < board.length; row++){
           if(board[row][0] == 'O') dfs(board, row, 0);
           if(board[row][board[0].length-1] == 'O') dfs(board, row, board[0].length-1);
       }

        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == 'O') dfs(board, 0, col);
            if(board[board.length-1][col] == 'O') dfs(board, board.length-1, col);
        }

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == 'T') board[row][col] = 'O';
                else if(board[row][col] == 'O') board[row][col] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;

        board[row][col] = 'T';

        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solve(board);
//        System.out.println(board[0]);
//        System.out.println(board[1]);
//        System.out.println(board[2]);
//        System.out.println(board[3]);
//        System.out.println(board[4]);
    }
}
