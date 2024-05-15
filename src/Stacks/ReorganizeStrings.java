package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReorganizeStrings {
//    public String reorganizeString(String s) {
//        Stack<Character> st1 = new Stack<>(); // correctly rearranged
//        Stack<Character> st2 = new Stack<>(); // remained
//
//        for(int i = 0; i < s.length(); i++){
//            if(st1.isEmpty() || st1.peek() != s.charAt(i)){
//                st1.add(s.charAt(i));
//                continue;
//            }
//
//            if(!st2.isEmpty() && st2.peek() != s.charAt(i)){
//                st1.add(st2.pop());
//                st1.add(s.charAt(i));
//            }else st2.add(s.charAt(i));
//        }
//
//        StringBuilder res = new StringBuilder();
//        while(!st1.isEmpty()) res.append(st1.pop());
//
//        while(!st2.isEmpty()){
//            boolean flag = false;
//            char c = st2.pop();
//            for(int i = 0; i < res.length(); i++){
//                if(res.charAt(i) == c) continue;
//
//                if(i-1 < 0 || res.charAt(i-1) != c){
//                    flag = true;
//                    res.insert(i, c);
//                    break;
//                }
//
//                if(i+1 == res.length() || res.charAt(i+1) != c){
//                    flag = true;
//                    res.insert(i+1, c);
//                    break;
//                }
//            }
//
//            if(!flag) return "";
//        }
//
//        return res.toString();
//    }


    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());
        StringBuilder res = new StringBuilder();

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> top1 = maxHeap.poll();

            if(res.isEmpty() || res.charAt(res.length()-1) != top1.getKey()) {
                res.append(top1.getKey());
                top1.setValue(top1.getValue()-1);
            }else{
                Map.Entry<Character, Integer> top2 = maxHeap.poll();
                if(top2 == null) return "";
                res.append(top2.getKey());
                top2.setValue(top2.getValue()-1);
                if(top2.getValue() != 0) maxHeap.add(top2);
            }

            if(top1.getValue() != 0) maxHeap.add(top1);
        }

        return res.toString();
    }
}
