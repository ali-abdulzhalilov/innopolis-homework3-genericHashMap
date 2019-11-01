package stc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class MyGenericHashMapTest {

    HashMap<String, String> h;
    MyGenericHashMap<String, String> gh;

    @Before
    public void setUp() throws Exception {
        h = new HashMap<>();
        gh = new MyGenericHashMap<>();
    }

    // create/update
    @Test
    public void put() {
        String key = "key";
        String value = "value";
        assertEquals(h.put(key, value), gh.put(key, value));

        String new_value = "new_value";
        assertEquals(h.put(key, value), gh.put(key, value));
    }

    @Test(expected = NullPointerException.class) // HashMap does the same thing
    public void putAllButPutNull(){
        gh.putAll(null);
    }

    @Test
    public void putAll() {
        HashMap<String, String> testMap = new HashMap<>();

        h.putAll(testMap); gh.putAll(testMap);
        assertEquals(h.size(), gh.size());

        String key1 = "first_key"; String value1 = "first_value";
        testMap.put(key1, value1);
        h.putAll(testMap); gh.putAll(testMap);
        assertEquals(h.size(), gh.size());
        assertEquals(h.get(key1), gh.get(key1));

        String key2 = "second_key"; String value2 = "second_value";
        testMap.put(key2, value2);
        h.putAll(testMap); gh.putAll(testMap);
        assertEquals(h.size(), gh.size());
        assertEquals(h.get(key2), gh.get(key2));

        testMap.put(key1, value2);
        h.putAll(testMap); gh.putAll(testMap);
        assertEquals(h.size(), gh.size());
        assertEquals(h.get(key1), gh.get(key1));
    }

    // ------------

    // read

    @Test
    public void get() {
        String key = "key";
        String value = "value";
        h.put(key, value); gh.put(key, value);
        assertEquals(h.get(key), gh.get(key));

        String new_value = "new_value";
        h.put(key, value); gh.put(key, value);
        assertEquals(h.get(key), gh.get(key));
    }

    @Test
    public void containsKey() {
        String key = "key";
        String value = "value";
        assertEquals(h.containsKey(key), gh.containsKey(key));

        h.put(key, value); gh.put(key, value);
        assertEquals(h.containsKey(key), gh.containsKey(key));
    }

    @Test
    public void containsValue() {
        String key = "key";
        String value = "value";
        assertEquals(h.containsValue(key), gh.containsValue(key));

        h.put(key, value); gh.put(key, value);
        assertEquals(h.containsValue(key), gh.containsValue(key));
    }

    @Test
    public void size() {
        String key = "key";
        String value = "value";
        assertEquals(h.size(), gh.size()); // should be 0

        h.put(key, value); gh.put(key, value);
        assertEquals(h.size(), gh.size()); // should be 1

        h.remove(key); gh.remove(key);
        assertEquals(h.size(), gh.size()); // should be 0
    }

    @Test
    public void isEmpty() {
        String key = "key";
        String value = "value";
        assertEquals(h.isEmpty(), gh.isEmpty()); // should be true

        h.put(key, value); gh.put(key, value);
        assertEquals(h.isEmpty(), gh.isEmpty()); // should be false

        h.clear(); gh.clear();
        assertEquals(h.isEmpty(), gh.isEmpty()); // should be true
    }

    @Test
    public void keySet() {
        assertEquals(h.keySet(), gh.keySet());

        String key = "key";
        String value = "value";
        h.put(key, value); gh.put(key, value);
        assertEquals(h.keySet(), gh.keySet());

        String other_value = "other_value";
        h.put(key, value); gh.put(key, value);
        assertEquals(h.keySet(), gh.keySet());

        h.remove(key); gh.remove(key);
        assertEquals(h.keySet(), gh.keySet());
    }

    @Test
    public void values() {
//        assertEquals(h.values(), gh.values());
//
//        String key = "key";
//        String value = "value";
//        h.put(key, value); gh.put(key, value);
//        assertEquals(h.values(), gh.values());
//
//        String other_key = "other_key";
//        String other_value = "other_value";
//        h.put(other_key, other_value); gh.put(other_key, other_value);
//        assertEquals(h.values(), gh.values());
//
//        h.put(key, other_value); gh.put(key, other_value);
//        assertEquals(h.values(), gh.values());
//
//        h.remove(key); gh.remove(key);
//        assertEquals(h.values(), gh.values());
    }

    @Test
    public void entrySet() {
        assertEquals(h.entrySet(), gh.entrySet());

        String key = "key";
        String value = "value";
        h.put(key, value); gh.put(key, value);
        assertEquals(h.entrySet(), gh.entrySet());

        String other_key = "other_key";
        String other_value = "other_value";
        h.put(other_key, other_value); gh.put(other_key, other_value);
        assertEquals(h.entrySet(), gh.entrySet());

        h.put(key, other_value); gh.put(key, other_value);
        assertEquals(h.entrySet(), gh.entrySet());

        h.remove(key); gh.remove(key);
        assertEquals(h.entrySet(), gh.entrySet());
    }
    // ----

    // delete
    @Test
    public void remove() {
        String key = "key";
        String value = "value";
        assertEquals(h.remove(key), gh.remove(key)); // should be null

        h.put(key, value); gh.put(key, value);
        assertEquals(h.get(key), gh.get(key)); // should be value
        assertEquals(h.remove(key), gh.remove(key)); // should be value
        assertEquals(h.get(key), gh.get(key)); // should be null
    }

    @Test
    public void clear() {
        String key = "key";
        String value = "value";

        assertEquals(h.size(), gh.size()); // should be 0

        h.put(key, value); gh.put(key, value);
        assertEquals(h.get(key), gh.get(key)); // should be "value"
        assertEquals(h.size(), gh.size()); // should be 1

        h.clear(); gh.clear();
        assertEquals(h.get(key), gh.get(key)); // should be null
        assertEquals(h.size(), gh.size()); // should be 0
    }
    // ------
}
