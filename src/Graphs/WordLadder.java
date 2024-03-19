package Graphs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        HashMap<String, List<String>> adjList = new HashMap<>();

        wordList.add(beginWord);
        for (String s : wordList) {
            for (int j = 0; j < s.length(); j++) {
                String pattern = s.substring(0, j) + "*" + s.substring(j + 1);
                if (!adjList.containsKey(pattern)) adjList.put(pattern, new ArrayList<>());
                adjList.get(pattern).add(s);
            }
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.add(beginWord);
        int res = 0;
        while(!q.isEmpty()){
            int qLen = q.size();
            res++;
            System.out.println(res);
            for(int i = 0; i < qLen; i++){
                String top = q.poll();

                if(top.equals(endWord)) return res;

                for (int j = 0; j < top.length(); j++) {
                    String pattern = top.substring(0, j) + "*" + top.substring(j + 1);
                    for(String s : adjList.get(pattern)){
                        if(!visited.contains(s)){
                            visited.add(s);
                            q.add(s);
                        }
                    }
                }

            }

        }

        return 0;

    }
}
