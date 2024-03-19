package kthdsa.F7;

public class Ndamer {
    private int[] queens;
    private int numSolutions;

    public Ndamer(int n) {
        queens = new int[n];
        numSolutions = 0;
    }

    public void solve() {
        solveNQueens(0, queens.length);
    }

    private void solveNQueens(int row, int n) {
        if (row == n) {
            numSolutions++;
            printSolution();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                solveNQueens(row + 1, n);
            }
        }
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        System.out.println("Solution " + numSolutions + ":");
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getNumSolutions() {
        return numSolutions;
    }

    public static void main(String[] args) {
        int n = 8; // Antal damer
        Ndamer problem = new Ndamer(n);
        problem.solve();
        System.out.println("Totalt antal lösningar: " + problem.getNumSolutions());
    }
}

