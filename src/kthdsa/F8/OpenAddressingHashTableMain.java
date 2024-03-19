package kthdsa.F8;

public class OpenAddressingHashTableMain {
    public static void main(String[] args) {
        OpenAddressingHashTable hashTable = new OpenAddressingHashTable();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println(hashTable.get("two")); // Output: 2

        hashTable.remove("two");
        System.out.println(hashTable.get("two")); // Output: null
    }
}
