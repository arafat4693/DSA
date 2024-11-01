package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex+1];
        Arrays.fill(row, 1);

        for(int i = 2; i <= rowIndex; i++){
            int[] nextRow = Arrays.copyOf(row, row.length);

            for(int j = 1; j < i; j++){
                nextRow[j] = row[j] + row[j-1];
            }

            row = nextRow;

            System.out.println(Arrays.toString(row));
        }

        List<Integer> res = new ArrayList<>();
        for(int j = 0; j <= rowIndex; j++) res.add(row[j]);

        return res;
    }
}
