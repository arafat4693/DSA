package LinkedLists;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4

//        lRUCache.put(2, 1); // cache is {2=1}
//        lRUCache.get(2);    // return 1
//        lRUCache.put(3, 2); // cache is {3=2}
//        lRUCache.get(2);    // return -1
//        lRUCache.get(3);    // return 2
    }
}
