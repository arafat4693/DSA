package LinkedLists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LFUCache {
    static class Node{
        int key;
        Node next;
        Node prev;
    }

    private HashMap<Integer, int[]> cache; // [value, frequency, time]
    private HashMap<Integer, Node> nodeMap;
    private int capacity;
    private Node head;

    private int time;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.head = null;
        this.time = 1;
    }

    public int get(int key) {
        if(cache.get(key) == null) return -1;

        int[] val1 = cache.get(key);
        val1[1]++;
        val1[2] = time++;
        Node keyNode = nodeMap.get(key);

        if(keyNode.next != null){
            Node keyNodeNext = nodeMap.get(keyNode.next.key);
            int[] val2 = cache.get(keyNodeNext.key);
            if(val1[1] >= val2[1]){
                swapNode(keyNode, keyNodeNext);
                if(keyNode == head) head = keyNodeNext;
            }
        }

        return val1[0];
    }

    public void put(int key, int value) {
        int[] prevVal = cache.get(key);
        if(prevVal == null){
            cache.put(key, new int[]{value, 1, time++});
        }
    }

    private void swapNode(Node keyNode, Node keyNodeNext){
        Node prevNode = keyNode.prev;
        keyNode.next = keyNodeNext.next;
        if(keyNodeNext.next != null){
            keyNodeNext.next.prev = keyNode;
        }
        keyNode.prev = keyNodeNext;
        keyNodeNext.next = keyNode;
        keyNodeNext.prev = prevNode;
    }
}
