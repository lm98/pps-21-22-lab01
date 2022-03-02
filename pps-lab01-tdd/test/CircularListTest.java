import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.EvenSelectStrategyFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl(new ArrayList<>());
    }

    @Test
    void testIsEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.size());
    }

    @Test
    void testNext(){
        circularList.add(1);
        circularList.add(2);
        var first = circularList.next();
        var second = circularList.next();
        var third = circularList.next();
        assertEquals(1, third.get());
    }

    @Test
    void testPrevious(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        var first = circularList.previous();
        var second = circularList.previous();
        var third = circularList.previous();
        assertEquals(1, third.get());
    }

    @Test
    void testReset(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        var first = circularList.next();
        var second = circularList.next();
        circularList.reset();
        var third = circularList.next();
        assertEquals(1, third.get());;
    }

    @Test
    void testNextWithStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        var selectStrategy = new EvenSelectStrategyFactory().createSelectStrategy();
        var result = circularList.next(selectStrategy);
        assertEquals(2, result.get());
    }

    @Test
    void testNextWithStrategyNotPresent(){
        circularList.add(3);
        circularList.add(2);
        var result = circularList.next(e->e==1);
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testHeadPositionAfterStrategy(){
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);
        circularList.add(2);
        circularList.next(e->e%2==0);
        var result = circularList.next();
        assertEquals(1, result.get());
    }
}
