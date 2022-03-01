import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.SelectStrategy;
import org.junit.jupiter.api.*;

import java.util.Optional;

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

    @Test
    void testNext(){
        cl.add(1);
        cl.add(2);

        var first = cl.next();
        var second = cl.next();
        var third = cl.next();
        assertEquals(Optional.of(1), third);
    }

    @Test
    void testPrevious(){
        cl.add(1);
        cl.add(2);
        cl.add(3);

        var first = cl.previous();
        var second = cl.previous();
        var third = cl.previous();
        assertEquals(Optional.of(1), third);
    }

    @Test
    void testReset(){
        cl.add(1);
        cl.add(2);
        cl.add(3);

        var first = cl.next();
        var second = cl.next();

        cl.reset();

        var third = cl.next();
        assertEquals(Optional.of(1), third);;
    }

    @Test
    void testNextWithStrategy(){
        cl.add(1);
        cl.add(2);
        cl.add(3);

        var result = cl.next(element -> element%2==0);
        assertEquals(Optional.of(2), result);
    }

    @Test
    void testNextWithStrategyNotPresent(){
        cl.add(1);
        cl.add(3);

        var result = cl.next(element -> element%2==0);
        assertEquals(Optional.empty(), result);
    }
}
