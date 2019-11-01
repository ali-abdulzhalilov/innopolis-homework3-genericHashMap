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

    private int hash(Object key) {
        int h = key.hashCode() >>> 1;
        return h & (capacity-1);
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
                return old_value;
            }
            entry = entry.next;
        }

        Entry<K, V> new_entry = new Entry<K, V>(key, value);
        addEntry(new_entry, entries, hash);
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }
    // -------------

    // read
    @Override
    public V get(Object key) {
        int hash = hash(key);

        Entry<K, V> entry = entries[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        Entry<K, V> entry;

        for (int i = 0; i < entries.length; i++) {
            entry = entries[i];
            while (entry != null) {
                if (entry.value.equals(value))
                    return true;

                entry = entry.next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        Entry<K, V> entry = entries[hash(key)];
        Entry<K, V> prev_entry = null;

        while (entry != null){
            if (entry.key.equals(key)) {
                if (prev_entry == null) entries[hash(key)] = entry.next;
                else prev_entry.next = entry.next;
                size--;
                return entry.value;
            }

            prev_entry = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < entries.length; i++)
            entries[i] = null;
        size = 0;
    }
    // ------

    // utils
    public void rehash() {

    }

    /* returns previous entry in bucket */
    private Entry<K, V> addEntry(Entry<K, V> entry, Entry<K, V>[] bucketList, int hashIndex) {
        if (entry == null || bucketList == null) return null;

        Entry<K, V> curEntry = bucketList[hashIndex];
        Entry<K, V> prevEntry = null;
        while (curEntry != null) {
            prevEntry = curEntry;
            curEntry = curEntry.next;
        }

        if (prevEntry != null)
            prevEntry.next = entry;
        else
            bucketList[hashIndex] = entry;

        size++;
        return prevEntry;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString()).append(" ").append(size()).append('/').append(capacity).append('\n');

        Entry<K, V> entry;
        for (int i = 0; i < entries.length; i++) {
            entry = entries[i];
            if (entry == null) continue;

            s.append("| ");
            while (entry != null) {
                s.append(entry).append(" ");
                entry = entry.next;
            }
            s.append('\n');
        }

        return s.toString();
    }

    // -----

    private class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

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
            Entry<K, V> old_next = this.next;
            this.next = next;
            return old_next;
        }

        @Override
        public String toString() {
            return "["+key+":"+value+"]";
        }
    }
}
