package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LockingTree {
    HashMap<Integer, Integer> locked = new HashMap<>();
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int[] p;

    public LockingTree(int[] parent) {
        p = Arrays.copyOf(parent, parent.length);

        for(int i = 0; i < parent.length; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int i = 1; i < parent.length; i++){
            adj.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num) != user) return false;
        locked.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num) || !checkAncestors(p, num)) return false;
        int oldSize = locked.size();
        unlockDescendant(adj, num);
        return oldSize != locked.size() && lock(num, user);
    }

    private boolean checkAncestors(int[] parent, int idx){
        if(parent[idx] == -1) return true;
        if(locked.containsKey(parent[idx])) return false;
        return checkAncestors(parent, parent[idx]);
    }

    private void unlockDescendant(HashMap<Integer, List<Integer>> adj, int node){
        for(Integer child : adj.get(node)){
            locked.remove(child);
            unlockDescendant(adj, child);
        }
    }
}
