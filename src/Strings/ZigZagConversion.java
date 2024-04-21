package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        List<Character>[] rows = new List[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new ArrayList<>();

        int row = 0, i = 0;

        while(i < s.length()){
            if(row == 0){
                int ub = Math.min(s.length()-i, numRows)+i;
                for(; i < ub; i++){
                    rows[row++].add(s.charAt(i));
                }
                row = numRows-Math.min(numRows, 2);
            }else{
                rows[row--].add(s.charAt(i++));
            }
        }

        StringBuilder res = new StringBuilder();

        for(List<Character> r : rows){
            for(Character c : r) res.append(c);
        }

        return res.toString();
    }
}
