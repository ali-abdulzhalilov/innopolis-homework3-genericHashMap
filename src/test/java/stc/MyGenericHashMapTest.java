package stc;

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
    }

    @Test
    public void containsKey() {
        String key = "key";
        String value = "value";
        assertEquals(h.containsKey(key), gh.containsKey(key));

        assertEquals(h.put(key, value), gh.put(key, value));
        assertEquals(h.containsKey(key), gh.containsKey(key));
    }

    @Test
    public void containsValue() {
        String key = "key";
        String value = "value";
        assertEquals(h.containsValue(key), gh.containsValue(key));

        assertEquals(h.put(key, value), gh.put(key, value));
        assertEquals(h.containsValue(key), gh.containsValue(key));
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
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
    }

    @Test
    public void clear() {
    }
    // ------
}
