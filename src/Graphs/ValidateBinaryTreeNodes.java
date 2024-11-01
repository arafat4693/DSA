package Graphs;

import java.util.Arrays;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1){
                if(parent[leftChild[i]] != -1) return false;
                parent[leftChild[i]] = i;
            }
            if(rightChild[i] != -1){
                if(parent[rightChild[i]] != -1) return false;
                parent[rightChild[i]] = i;
            }
        }

        int root = -1;
        for(int i = 0; i < n; i++){
            if(parent[i] != -1) continue;
            if(root != -1) return false;
            root = i;
        }

        if(root == -1) return false;

        boolean[] visited = new boolean[n];

        if(!dfs(leftChild, rightChild, root, visited)) return false;

        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }

        return true;
    }

    private boolean dfs(int[] left, int[] right, int root, boolean[] visited){
        if(visited[root]) return false;

        visited[root] = true;
        if(left[root] != -1 && !dfs(left, right, left[root], visited)) return false;
        if(right[root] != -1 && !dfs(left, right, right[root], visited)) return false;

        return true;
    }
}
