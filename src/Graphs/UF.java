package Graphs;

import java.util.Arrays;

public class UF {
    private int[] parent;

    UF(int size){
        this.parent = new int[size];
        Arrays.fill(parent, -1);
    }

    public void union(int n1, int n2){
        int r1 = find(n1), r2 = find(n2);
        if(r1 == r2) return;

        if(parent[r1] < parent[r2]){
            parent[r1] += parent[r2];
            parent[r2] = r1;
        }else {
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }
    }

    public int find(int n){
        if(parent[n] < 0) return n;
        return find(parent[n]);
    }
}
