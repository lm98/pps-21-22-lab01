import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.EvenSelectStrategyFactory;
import lab01.tdd.SelectStrategy;
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
        assertEquals(Optional.of(1), third);
    }

    @Test
    void testPrevious(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        var first = circularList.previous();
        var second = circularList.previous();
        var third = circularList.previous();
        assertEquals(Optional.of(1), third);
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
        assertEquals(Optional.of(1), third);;
    }

    @Test
    void testNextWithStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        var selectStrategy = new EvenSelectStrategyFactory().createSelectStrategy();
        var result = circularList.next(selectStrategy);
        assertEquals(Optional.of(2), result);
    }

    @Test
    void testNextWithStrategyNotPresent(){
        circularList.add(1);
        circularList.add(3);
        var selectStrategy = new EvenSelectStrategyFactory().createSelectStrategy();
        var result = circularList.next(selectStrategy);
        assertEquals(Optional.empty(), result);
    }
}
