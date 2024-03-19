package kthdsa.F8;

import java.util.Arrays;

public class OpenAddressingHashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;

    private Entry[] table;
    private int size;

    public OpenAddressingHashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void put(String key, int value) {
        if (key == null) return;

        if ((double) (size + 1) / table.length > LOAD_FACTOR_THRESHOLD) {
            rehash();
        }

        int hash = hash(key);
        int index = hash % table.length;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length;
        }

        table[index] = new Entry(key, value);
        size++;
    }

    public Integer get(String key) {
        if (key == null) return null;

        int hash = hash(key);
        int index = hash % table.length;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length;
        }

        if (table[index] != null && table[index].key.equals(key)) {
            return table[index].value;
        } else {
            return null;
        }
    }

    public void remove(String key) {
        if (key == null) return;

        int hash = hash(key);
        int index = hash % table.length;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length;
        }

        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
            size--;
        }
    }

    private int hash(String key) {
        return key.hashCode() & 0x7FFFFFFF; // To ensure non-negative hash value
    }

    private void rehash() {
        Entry[] oldTable = table;
        table = new Entry[oldTable.length * 2];

        Arrays.fill(table, null);
        size = 0;

        for (Entry entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

