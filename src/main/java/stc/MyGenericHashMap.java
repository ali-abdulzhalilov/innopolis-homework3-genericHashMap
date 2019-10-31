package stc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyGenericHashMap<K, V> implements Map<K, V> {
    private int size;
    private int capacity;
    private float loadFactor;
    private Entry<K, V>[] entries;

    public MyGenericHashMap() {
        this(16);
    }

    public MyGenericHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public MyGenericHashMap(int initialCapacity, float loadFactor) {
        this.size = 0;
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.entries = new Entry[initialCapacity];
    }

    private int hash(K key) {
        int h = key.hashCode() >>> 1;
        return h & (capacity);
    }

    // create/update
    @Override
    public V put(K key, V value) {
        int hash = hash(key);

        Entry<K, V> entry = entries[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                V old_value = entry.value;
                entry.value = value;
                return value;
            }
        }

        entry = new Entry<K, V>(key, value);
        addEntry(entry, entries, hash);
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }
    // -------------

    // read
    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }
    // ----

    // delete
    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }
    // ------

    // utils
    public void rehash() {

    }

    /* returns previous entry in bucket */
    private Entry<K, V> addEntry(Entry<K, V> entry, Entry<K, V>[] bucketList, int hashIndex) {
        if (entry == null || bucketList == null) return null;

        if (bucketList[hashIndex] == null) {
            bucketList[hashIndex] = entry;
            return null;
        }

        Entry<K, V> curEntry = bucketList[hashIndex];
        while (curEntry != null)
            curEntry = curEntry.next;

        curEntry.next = entry;
        size++;
        return curEntry;
    }


    // -----

    private class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private Entry next;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old_value = this.value;
            this.value = value;
            return old_value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public Entry<K, V> setNext(Entry<K, V> next) {
            Entry old_next = this.next;
            this.next = next;
            return old_next;
        }
    }
}
