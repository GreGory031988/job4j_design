package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        if (count == capacity * LOAD_FACTOR) {
            expand();
        }
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (var entry : table) {
            if (entry != null) {
                int newIndex = getIndex(entry.key);
                    newTable[newIndex] = entry;
            }
        }
        table = newTable;
    }

    private int getIndex(K key) {
        return key == null ? 0 : indexFor(hash(key.hashCode()));
    }

    private boolean getEquals(K key, int index) {
        return table[index] != null
                && Objects.hashCode(key) == Objects.hashCode(table[index].key)
                && Objects.equals(key, table[index].key);
    }

    @Override
    public V get(K key) {
        V rsl = null;
        int index = getIndex(key);
        if (getEquals(key, index)) {
            rsl = table[index].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = getIndex(key);
        if (getEquals(key, index)) {
            table[index] = null;
            rsl = true;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (currentIndex < table.length && table[currentIndex] == null) {
                    currentIndex++;
                }
                    return currentIndex < table.length;
                }

                @Override
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return table[currentIndex++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
