package ArrayAndHashing;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char currentValue = board[i][j];
                if(currentValue != '.'){
                    if(!seen.add(currentValue + " seen in row " + i) || !seen.add(currentValue + " seen in col " + j) || !seen.add(currentValue + " seen in cube " + i/3 + "-" + j/3)) return false;
                }
            }
        }

        return true;
    }
}
