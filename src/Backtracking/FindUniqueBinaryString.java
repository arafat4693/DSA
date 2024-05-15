package Backtracking;

import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> numsHash = new HashSet<>(Arrays.asList(nums));
        return backtrack(new StringBuilder(), nums.length, numsHash);
    }

    private String backtrack(StringBuilder subRes, int length, HashSet<String> numsHash){
        if(subRes.length() == length){
            if(!numsHash.contains(subRes.toString())) return subRes.toString();
            return "";
        }

        subRes.append('0');
        String res1 = backtrack(subRes, length, numsHash);
        if (!res1.isEmpty()) return res1;
        subRes.deleteCharAt(subRes.length()-1);

        subRes.append('1');
        String res2 = backtrack(subRes, length, numsHash);
        if(!res2.isEmpty()) return res2;
        subRes.deleteCharAt(subRes.length()-1);

        return "";
    }
}
