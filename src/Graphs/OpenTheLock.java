package Graphs;

import java.util.*;

public class OpenTheLock {
    class State{
        String code;
        int moves;
        State(String code, int moves){
            this.code = code;
            this.moves = moves;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));

        Queue<State> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        State root = new State("0000", 0);

        if(!set.contains(root.code)) q.add(root);

        while(!q.isEmpty()){
            State top = q.poll();

            if(top.code.equals(target)) return top.moves;

            if(visited.contains(top.code)) continue;

            visited.add(top.code);

            for(int i = 0; i < 4; i++){
                int c = Integer.parseInt(String.valueOf(top.code.charAt(i)));

                int right = c+1 > 9 ? 0 : c+1;
                int left = c-1 < 0 ? 9 : c-1;

                String rightStr = top.code.substring(0, i) + right + top.code.substring(i+1);
                String leftStr = top.code.substring(0, i) + left + top.code.substring(i+1);

                if(!set.contains(rightStr)) q.add(new State(rightStr, top.moves+1));
                if(!set.contains(leftStr)) q.add(new State(leftStr, top.moves+1));
            }
        }

        return -1;
    }
}
