import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList cl;

    @BeforeEach
    void setup(){
        cl = new CircularListImpl();
    }

    @Test
    void testIsEmpty(){
        assertTrue(cl.isEmpty());
    }

    @Test
    void testAdd(){
        cl.add(1);
        assertFalse(cl.isEmpty());
    }

    @Test
    void testSize(){
        cl.add(1);
        cl.add(2);
        assertEquals(2,cl.size());
    }

}
