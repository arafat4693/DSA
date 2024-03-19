package kthdsa.F8;

public class HashTableTest {
    public static void main(String[] args) {
        // Test 1: Lägga till nyckel-värde-par
        HashTableBucket<Integer, String> hashTable = new HashTableBucket<>(5);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");
        hashTable.put(4, "Four");
        hashTable.put(5, "Five");

        // Test 2: Hämta värden från hashtabellen
        System.out.println("Test 2:");
        System.out.println("Value for key 3: " + hashTable.get(3));
        System.out.println("Value for key 5: " + hashTable.get(5));
        System.out.println();

        // Test 3: Ta bort nyckel-värde-par från hashtabellen
        System.out.println("Test 3:");
        System.out.println("Hashtable before removal:");
        System.out.println(hashTable);
        hashTable.remove(3);
        System.out.println("Hashtable after removing key 3:");
        System.out.println(hashTable);
        System.out.println();

        // Test 4 och 5: Kontrollera om hashtabellen korrekt ökar storleken när antalet nyckel-värde-par överstiger 75% av tabellens storlek
        // och omplacering av befintliga element görs korrekt när tabellstorleken ökar.
        System.out.println("Test 4 och 5:");
        System.out.println("Hashtable before resize:");
        System.out.println(hashTable);
        hashTable.put(6, "Six");
        hashTable.put(7, "Seven");
        hashTable.put(8, "Eight");
        System.out.println("Hashtable after adding more elements:");
        System.out.println(hashTable);
        System.out.println();

        // Test 6: Verifiera att toString-metoden genererar en korrekt representation av hashtabellen
        System.out.println("Test 6:");
        System.out.println("Hashtable toString representation:");
        System.out.println(hashTable.toString());
    }
}

