package org.rainzha.practicalunittesting.exercises.chapter03;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {
    private HashMap map;

    @Before
    public void setUp(){
        map = new HashMap();
    }

    @Test
    public void getObjectByKey() {
        map.put("key", "value");

        assertThat(map.get("key")).isEqualTo("value");
    }

    @Test
    public void shouldGetNewValueForSameKey() {
        map.put("key", "value");
        map.put("key", "newValue");

        assertThat(map.get("key")).isEqualTo("newValue");
    }

    @Test
    public void shouldEmptyHashMapByClearMethod(){
        map.put("key", "value");
        map.put("key1", "newValue");
        map.clear();

        assertThat(map).isEmpty();
    }

    @Test
    public void shouldSetNullForKey(){
        map.put(null, "value");

        assertThat(map.get(null)).isEqualTo("value");
    }
}
