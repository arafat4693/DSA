package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
//        HashMap<Character, Integer> freq = new HashMap<>();
//        List<Integer> res = new ArrayList<>();
//
//        for(int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
//
//        int l = 0;
//
//        for(int r = 0; r <= s.length(); r++){
//            boolean newPartition = true;
//
//            for(int i = l; i < r; i++){
//                if(freq.get(s.charAt(i)) != 0) {
//                    newPartition = false;
//                    break;
//                }
//            }
//
//            if(newPartition && r != l){
//                res.add(r-l);
//                l = r;
//            }
//
//            if(r < s.length()) freq.put(s.charAt(r), freq.get(s.charAt(r)) - 1);
//        }
//
//        return res;

        HashMap<Character, Integer> last = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) last.put(s.charAt(i), i);

        int size = 0, end = -1;

        for(int i = 0; i < s.length(); i++){
            size++;
            end = Math.max(end, last.get(s.charAt(i)));

            if(i == end){
                res.add(size);
                size = 0;
                end = -1;
            }
        }

        return res;
    }
}
