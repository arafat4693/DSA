package LinkedLists;

import java.util.HashMap;

class Dll {
    int val;
    Dll next;
    Dll prev;

    Dll() {
    }

    Dll(int val, Dll next, Dll prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class HValue {
    int value;
    Dll node;

    HValue(int value, Dll node){
        this.value = value;
        this.node = node;
    }
}

public class LRUCache {
    private int capacity;
    private HashMap<Integer, HValue> LRUCache;
    private Dll head;
    private Dll tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        LRUCache = new HashMap<>();
    }

    private void updatedNode(Dll node){
        if(LRUCache.size() == 1) return;

        if(node == head){
            head = node.next;
            node.next = null;
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }else if(node != tail){
            Dll prevNode = node.prev;
            Dll nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node.next = null;
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
    }

    public int get(int key) {
        HValue cache = LRUCache.get(key);
        if(cache == null) return -1;
        Dll node = cache.node;
        updatedNode(node);
        return  cache.value;
    }

    public void put(int key, int value) {
        if(LRUCache.isEmpty()){
            this.head = new Dll(key, null, null);
            this.tail = this.head;
            LRUCache.put(key, new HValue(value, this.head));
        }else {
            HValue cache = LRUCache.get(key);
            if(cache != null){
                Dll node = cache.node;
                updatedNode(node);
                LRUCache.put(key, new HValue(value, node));
            }else{
                if(LRUCache.size() < capacity){
                    Dll newNode = new Dll(key, null, this.tail);
                    this.tail.next = newNode;
                    this.tail = newNode;
                    LRUCache.put(key, new HValue(value, this.tail));
                }else{
                    LRUCache.remove(this.head.val);
                    Dll newNode = new Dll(key, null, this.tail);
                    if(LRUCache.size()+1 == 1){
                        this.head = newNode;
                    }else{
                        this.head = this.head.next;
                        this.tail.next = newNode;
                    }
                    this.tail = newNode;
                    LRUCache.put(key, new HValue(value, this.tail));
                }
            }
        }
    }
}

//class Dll {
//    int val;
//    Dll next;
//    Dll prev;
//
//    Dll() {
//    }
//
//    Dll(int val, Dll next, Dll prev) {
//        this.val = val;
//        this.next = next;
//        this.prev = prev;
//    }
//}
//
//class HValue {
//    int value;
//    Dll node;
//
//    HValue(int value, Dll node){
//        this.value = value;
//        this.node = node;
//    }
//}
//
//public class LRUCache {
//    private int capacity;
//    private int size;
//    private HashMap<Integer, HValue> LRUCache;
//    private Dll head;
//    private Dll tail;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.size = 0;
//        LRUCache = new HashMap<>();
//    }
//
//    private void updatedNode(Dll node){
//        if(size <= 1) return;
//
//        if(node == head){
//            head = node.next;
//            node.next = null;
//            node.prev = this.tail;
//            this.tail.next = node;
//            this.tail = node;
//        }else if(node != tail){
//            Dll prevNode = node.prev;
//            Dll nextNode = node.next;
//            prevNode.next = nextNode;
//            nextNode.prev = prevNode;
//            node.next = null;
//            node.prev = this.tail;
//            this.tail.next = node;
//            this.tail = node;
//        }
//    }
//
//    public int get(int key) {
//        HValue cache = LRUCache.get(key);
//        if(cache == null) return -1;
//        Dll node = cache.node;
//        updatedNode(node);
//        return  cache.value;
//    }
//
//    public void put(int key, int value) {
//        if(size == 0){
//            this.head = new Dll(key, null, null);
//            this.tail = this.head;
//            LRUCache.put(key, new HValue(value, this.head));
//            size++;
//        }else {
//            HValue cache = LRUCache.get(key);
//            if(cache != null){
//                Dll node = cache.node;
//                updatedNode(node);
//                LRUCache.put(key, new HValue(value, node));
//            }else{
//                if(size < capacity){
//                    Dll newNode = new Dll(key, null, this.tail);
//                    this.tail.next = newNode;
//                    this.tail = newNode;
//                    LRUCache.put(key, new HValue(value, this.tail));
//                    size++;
//                }else{
//                    LRUCache.remove(this.head.val);
//                    Dll newNode = new Dll(key, null, this.tail);
//                    if(size == 1){
//                        this.head = newNode;
//                    }else{
//                        this.head = this.head.next;
//                        this.tail.next = newNode;
//                    }
//                    this.tail = newNode;
//                    LRUCache.put(key, new HValue(value, this.tail));
//                }
//            }
//        }
//    }
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */