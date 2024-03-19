package kthdsa.L3;

public class test {
    private int solutions;
    private final int[][] board;
    public test(int row, int col){
        if(row < 1 || row > 5 || col < 1 || col > 5) throw new IllegalStateException("Only 1 to 5 are allowed");

        solutions = 0;
        board = new int[5][5];

        // grå
        board[row-1][col-1] = -1;

        solve(0, 0, 0);
    }

    public int getSolutions() {
        return solutions;
    }

    private void solve(int pieces, int row, int col){
        System.out.println("In");

        if(pieces == 8) {
            solutions++;
            return;
        }

        if(col > 4){
            row++;
            col = 0;
        }

        if(board[row][col] != 0) solve(pieces, row, col+1);

        if(addedFirstPiece(row, col)){
            solve(pieces+1, row, col+2);
            removeFirstPiece(row, col);
        }

        if(addedSecondPiece(row, col)){
            solve(pieces+1, row, col+1);
            removeSecondPiece(row, col);
        }

        if(addedThirdPiece(row, col)){
            solve(pieces+1, row, col+2);
            removeThirdPiece(row, col);
        }

        if(addedFourthPiece(row, col)){
            solve(pieces+1, row, col+1);
            removeFourthPiece(row, col);
        }
    }


    /*
        # #
        #
    */
    private boolean addedFirstPiece(int row, int col){
        if((col + 1) > 4 || (row + 1) > 4 || board[row][col] != 0 || board[row][col+1] != 0 || board[row+1][col] != 0) return false;
        board[row][col] = 1;
        board[row][col+1] = 1;
        board[row+1][col] = 1;
        return true;
    }

    private void removeFirstPiece(int row, int col){
        board[row][col] = 0;
        board[row][col+1] = 0;
        board[row+1][col] = 0;
    }

    /*
        # #
          #
    */
    private boolean addedSecondPiece(int row, int col){
        if((col - 1) < 0 || (row + 1) > 4 || board[row][col] != 0 || board[row][col-1] != 0 || board[row+1][col] != 0) return false;
        board[row][col] = 1;
        board[row][col-1] = 1;
        board[row+1][col] = 1;
        return true;
    }

    private void removeSecondPiece(int row, int col){
        board[row][col] = 0;
        board[row][col-1] = 0;
        board[row+1][col] = 0;
    }

    /*
       #
       # #
   */
    private boolean addedThirdPiece(int row, int col){
        if((col + 1) > 4 || (row - 1) < 0 || board[row][col] != 0 || board[row][col+1] != 0 || board[row-1][col] != 0) return false;
        board[row][col] = 1;
        board[row][col+1] = 1;
        board[row-1][col] = 1;
        return true;
    }

    private void removeThirdPiece(int row, int col){
        board[row][col] = 0;
        board[row][col+1] = 0;
        board[row-1][col] = 0;
    }

    /*
          #
        # #
    */
    private boolean addedFourthPiece(int row, int col){
        if((col - 1) < 0 || (row - 1) < 0 || board[row][col] != 0 || board[row][col-1] != 0 || board[row-1][col] != 0) return false;
        board[row][col] = 1;
        board[row][col-1] = 1;
        board[row-1][col] = 1;
        return true;
    }

    private void removeFourthPiece(int row, int col){
        board[row][col] = 0;
        board[row][col-1] = 0;
        board[row-1][col] = 0;
    }
}
