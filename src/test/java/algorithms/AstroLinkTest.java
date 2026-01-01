package algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.javagrader.Grade;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

@Grade

public class AstroLinkTest {

    @Test
    @Grade(value = 1, cpuTimeout = 1)
    void testInitialization() {
        AstroLink astroLink = new AstroLink(5);

        assertEquals(4, astroLink.successor[0]);
        assertEquals(0, astroLink.predecessor[4]);

        for (int i = 1; i < 4; i++) {
            assertEquals(i, astroLink.successor[i]); // Not in the chain
            assertEquals(i, astroLink.predecessor[i]); // Not in the chain
        }
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1)
    void testInsertAfter() {
        AstroLink astroLink = new AstroLink(5);

        // Insert satellite 2 between 0 and 4
        astroLink.insertAfter(0, 2);

        assertEquals(2, astroLink.successor[0]);
        assertEquals(4, astroLink.successor[2]);
        assertEquals(0, astroLink.predecessor[2]);
        assertEquals(2, astroLink.predecessor[4]);

        // Insert satellite 1 between 0 and 2
        astroLink.insertAfter(0, 1);

        assertEquals(1, astroLink.successor[0]);
        assertEquals(2, astroLink.successor[1]);
        assertEquals(0, astroLink.predecessor[1]);
        assertEquals(1, astroLink.predecessor[2]);
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1)
    void testInsertBefore() {
        AstroLink astroLink = new AstroLink(5);

        // Insert satellite 2 between 0 and 4
        astroLink.insertBefore(4, 2); // 0 <-> 2 <-> 4

        assertEquals(2, astroLink.successor[0]);
        assertEquals(4, astroLink.successor[2]);
        assertEquals(0, astroLink.predecessor[2]);
        assertEquals(2, astroLink.predecessor[4]);

        // Insert satellite 1 between 0 and 2
        astroLink.insertBefore(2, 1); // 0 <-> 1 <-> 2 <-> 4

        assertEquals(1, astroLink.successor[0]);
        assertEquals(2, astroLink.successor[1]);
        assertEquals(0, astroLink.predecessor[1]);
        assertEquals(1, astroLink.predecessor[2]);
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1)
    void testIterator() {
        AstroLink astroLink = new AstroLink(5);


        astroLink.insertAfter(0, 1); // 0 <-> 1 <-> 4
        astroLink.insertAfter(1, 2); // 0 <-> 1 <-> 2 <-> 4

        Iterator<Integer> iterator = astroLink.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(4, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1)
    void testIteratorNoSuchElementException() {
        AstroLink astroLink = new AstroLink(5);
        Iterator<Integer> iterator = astroLink.iterator();

        iterator.next(); // 0
        iterator.next(); // 4
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

}