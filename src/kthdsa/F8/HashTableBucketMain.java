package kthdsa.F8;

public class HashTableBucketMain {
    public static void main(String[] args) {
        HashTableBucket<Integer, String> hashTable = new HashTableBucket<>(5);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");
        hashTable.put(4, "Four");
        hashTable.put(5, "Five");
        hashTable.put(6, "Six");
        hashTable.put(7, "Seven");
        hashTable.put(8, "Eight");
        hashTable.put(9, "Nine");
        hashTable.put(10, "Ten");

        System.out.println("Initial hashtable:");
        System.out.println(hashTable);
    }
}
