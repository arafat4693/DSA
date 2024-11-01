package Graphs;

import java.util.*;

public class RmvMinNrOfEdgesToFullyTraverse {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF alice = new UF(n+1);
        UF bob = new UF(n+1);

        int removed = 0, ac = n, bc = n;

        for(int[] edge : edges){
            if(edge[0] == 3){
                if(!alice.union(edge[1], edge[2])) removed++;
                else ac--;
                if(!bob.union(edge[1], edge[2])) removed++;
                else bc--;
            }
        }

        for(int[] edge: edges){
            if(edge[0] == 1){
                if(!alice.union(edge[1], edge[2])) removed++;
                else ac--;
            }

            if(edge[0] == 2){
                if(!bob.union(edge[1], edge[2])) removed++;
                else bc--;
            }
        }

        return ac == 1 && bc == 1 ? removed : -1;
    }
}
