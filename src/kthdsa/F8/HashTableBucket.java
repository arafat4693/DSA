package kthdsa.F8;

import java.util.StringJoiner;

public class HashTableBucket<K, V> {
    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }
    private SingleLinkedList<Entry<K, V>>[] table;
    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new SingleLinkedList[initialSize];
    }
    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].addFirst(new Entry<>(key, value));
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] != null) {
            table[index].remove(index);
        }
    }

    private void resizeAndRehash() {
        int newCapacity = table.length * 2;
        SingleLinkedList<Entry<K, V>>[] newTable = new SingleLinkedList[newCapacity];

        // Flytta alla befintliga element till den nya tabellen
        for (SingleLinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newIndex = entry.key.hashCode() % newCapacity;
                    if (newIndex < 0) {
                        newIndex += newCapacity;
                    }
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new SingleLinkedList<>();
                    }
                    newTable[newIndex].addFirst(entry);
                }
            }
        }

        // Uppdatera tabellen och storleken
        table = newTable;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (SingleLinkedList<Entry<K, V>> entries : table) {
            if (entries != null) {
                for (Entry<K, V> entry : entries) {
                    joiner.add("(" + entry.key + "=" + entry.value + ")");
                }
            }
        }
        return joiner.toString();
    }
}
