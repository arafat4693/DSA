package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASeq {
//    public List<String> findRepeatedDnaSequences(String s) {
//        HashMap<String, Integer> freq = new HashMap<>();
//        List<String> res = new ArrayList<>();
//        StringBuilder subRes = new StringBuilder();
//
//        int l = 0;
//        for(int r = 0; r < s.length(); r++){
//            subRes.append(s.charAt(r));
//
//            if(r-l+1 < 10){
//                continue;
//            }
//
//            freq.put(subRes.toString(), freq.getOrDefault(subRes.toString(), 0)+1);
//            subRes.deleteCharAt(0);
//            l++;
//        }
//
//        for(String k : freq.keySet()){
//            if(freq.get(k) > 1) res.add(k);
//        }
//
//        return res;
//    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for(int i = 0; i <= s.length()-10; i++){
            String pattern = s.substring(i, i+10);
            if(!seen.add(pattern)) res.add(pattern);
        }

        return new ArrayList<>(res);
    }
}
