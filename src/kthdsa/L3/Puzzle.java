package kthdsa.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle {

    private int solutions;
    private int[][] board;

    public Puzzle(){
        solutions = 0;
    }

    public int getSolutions() {
        return solutions;
    }

    public void play(int row, int col){
        if(row < 1 || row > 5 || col < 1 || col > 5) throw new IllegalStateException("Only 1 to 5 are allowed");

        board = new int[5][5];
        solutions = 0;

        // grå
        board[row-1][col-1] = 5;

        backtrack(0, 0, 0);
    }

    private void backtrack(int row, int col, int pieceCount) {
        if (pieceCount == 8) {
            solutions++;
            printResult();
            return;
        }
        if (col>board.length-1) {
            col = 0;
            row += 1;
        }
        if (board[row][col] != 0) backtrack(row, col+1, pieceCount);

        if (addedShapeOne(board, row, col)) {
            backtrack(row, col+2, pieceCount+1);
            removeShapeOne(board, row, col);
        }

        if (addedShapeTwo(board, row, col)) {
            backtrack(row, col+2, pieceCount+1);
            removeShapeTwo(board, row, col);
        }

        if (addedShapeThree(board, row, col)) {
            backtrack(row, col+1, pieceCount+1);
            removeShapeThree(board, row, col);
        }

        if (addedShapeFour(board, row, col)) {
            backtrack(row, col+1, pieceCount+1);
            removeShapeFour(board, row, col);
        }
    }

    private boolean addedShapeOne(int[][] board, int row, int col){
        if ( (col+1) > board.length-1 ||  (row+1) > board.length-1) return false;
        if (board[row][col] != 0 ||
            board[row][col+1] != 0 ||
            board[row+1][col] != 0) {
            return false;
        }
        board[row][col] = board[row][col+1] = board[row+1][col] = 1;
        return true;
    }
    private void removeShapeOne(int[][] board, int row, int col) {
        board[row][col] = board[row][col+1] = board[row+1][col] = 0;
    }

    private boolean addedShapeTwo(int[][] board, int row, int col){
        if ( (col+1) > board.length-1 || (row+1) > board.length-1) return false;
        if (board[row][col] != 0 ||
                board[row][col+1] != 0 ||
                board[row+1][col+1] != 0) {
            return false;
        }
        board[row][col] = board[row][col+1] = board[row+1][col+1] = 2;
        return true;
    }
    private void removeShapeTwo(int[][] board, int row, int col) {
        board[row][col] = board[row][col+1] = board[row+1][col+1] = 0;
    }

    private boolean addedShapeThree(int[][] board, int row, int col){
        if ( (col-1) < 0 || (row+1) > board.length-1) return false;
        if (board[row][col] != 0 ||
                board[row+1][col] != 0 ||
                board[row+1][col-1] != 0) {
            return false;
        }
        board[row][col] = board[row+1][col] = board[row+1][col-1] = 3;
        return true;
    }
    private void removeShapeThree(int[][] board, int row, int col) {
        board[row][col] = board[row+1][col] = board[row+1][col-1] = 0;
    }

    private boolean addedShapeFour(int[][] board, int row, int col){
        if ( (col+1) > board.length-1 || (row+1) > board.length-1) return false;
        if (board[row][col] != 0 ||
                board[row+1][col] != 0 ||
                board[row+1][col+1] != 0) {
            return false;
        }
        board[row][col] = board[row+1][col] = board[row+1][col+1] = 4;
        return true;
    }
    private void removeShapeFour(int[][] board, int row, int col) {
        board[row][col] = board[row+1][col] = board[row+1][col+1] = 0;
    }

    private void printResult(){
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
