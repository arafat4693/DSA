package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary {
    public static String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                adj.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());

            if(w1.length() > w2.length() && w1.substring(0, minLength).equals(w2.substring(0, minLength))) return "";

            for(int j = 0; j < minLength; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        HashMap<Character, Boolean> visit = new HashMap<>();

        for(Character c : adj.keySet()){
            if(dfs(res, adj, visit, c)) return "";
        }

        return res.reverse().toString();
    }

    private static boolean dfs(StringBuilder res, HashMap<Character, HashSet<Character>> adj, HashMap<Character, Boolean> visit, Character c){
        if(visit.containsKey(c)) return visit.get(c);
        visit.put(c, true);
        for(Character nei : adj.get(c)){
            if(dfs(res, adj, visit, nei)) return true;
        }
        visit.put(c, false);
        res.append(c);
        return false;
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"z", "o"};
        String[] words = new String[]{"hrn","hrf","er","enn","rfnn"};
        System.out.println(foreignDictionary(words));
    }
}
