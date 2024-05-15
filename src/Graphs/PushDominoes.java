package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PushDominoes {
    static class State{
        int idx;
        char ch;

        State(int idx, char ch){
            this.idx = idx;
            this.ch = ch;
        }
    }

    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();

        Queue<State> queue = new LinkedList<>();

        for(int i = 0; i < dominoes.length(); i++){
            if(dominoes.charAt(i) != '.') queue.add(new State(i, dominoes.charAt(i)));
        }

        while(!queue.isEmpty()){
            State top = queue.poll();

            if(top.ch == 'L' && top.idx > 0 && dom[top.idx-1] == '.'){
                dom[top.idx-1] = 'L';
                queue.add(new State(top.idx - 1, 'L'));
            }else if(top.ch == 'R'){
                if(top.idx + 1 < dom.length && dom[top.idx+1] == '.'){
                    if(top.idx + 2 < dom.length && dom[top.idx+2] == 'L') queue.poll();
                    else {
                        dom[top.idx+1] = 'R';
                        queue.add(new State(top.idx + 1, 'R'));
                    }
                }
            }
        }

        return new String(dom);
    }
}
