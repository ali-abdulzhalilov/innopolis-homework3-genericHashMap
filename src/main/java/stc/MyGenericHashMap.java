package stc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyGenericHashMap<K, V> implements Map<K, V> {


    // create/update
    @Override
    public V put(K key, V value) {
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
    public Set<Entry<K, V>> entrySet() {
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
    // -----
}
