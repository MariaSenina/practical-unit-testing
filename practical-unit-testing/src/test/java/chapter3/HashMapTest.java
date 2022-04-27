package chapter3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {
    private Map<String, String> map;

    @Before
    public void setUp() {
        map = new HashMap<>();
    }

    public static Object[] getValidMapValues() {
        return new Object[] {
                new Object[] {"test0", "test0"},
                new Object[] {null, "test1"}
        };
    }

    @Test
    @Parameters(method = "getValidMapValues")
    public void shouldRetrieveCorrectValueWithGetMethod(String key, String value) {
        map.put(key, value);

        assertEquals(value, map.get(key));
    }

    @Test
    @Parameters(method = "getValidMapValues")
    public void shouldReplaceValueWithSameKey(String key, String originalValue) {
        map.put(key, originalValue);
        map.put(key, "test5");

        assertNotEquals(map.get(key), originalValue);
    }

    @Test
    @Parameters(method = "getValidMapValues")
    public void shouldRemoveAllMapContentWhenClearMethodCalled(String key, String value) {
        map.put(key, value);
        map.clear();

        assertTrue(map.isEmpty());
    }

    @Test
    public void shouldAcceptElementWithNullKey() {
        map.put(null, "test");

        assertFalse(map.isEmpty());
    }
}
