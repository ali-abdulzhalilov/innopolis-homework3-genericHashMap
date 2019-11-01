package stc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MyGenericHashMapTest {

    HashMap<String, String> h;
    MyGenericHashMap<String, String> gh;

    @Before
    public void setUp() throws Exception {
        h = new HashMap<>();
        gh = new MyGenericHashMap<>();
    }

    @After
    public void tearDown() throws Exception {

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

    @Test
    public void putAll() {
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
    }

    @Test
    public void values() {
    }

    @Test
    public void entrySet() {
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
