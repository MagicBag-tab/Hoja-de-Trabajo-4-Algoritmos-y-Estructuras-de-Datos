import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class DoubleListTest {

    public DoubleList<Integer> list;

    @Before
    public void setUp() {
        list = new DoubleList<>();
    }

    @Test
    public void testDoubleListAdd() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.count);
    }

    @Test
    public void testDoubleListDelete() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.delete(1);
        assertEquals(2, list.count);
    }

    @Test
    public void testDoubleListDeleteFirst() {
        list.add(10);
        list.add(20);
        list.delete(0);
        assertEquals(1, list.count);
    }

    @Test
    public void testDoubleListDeleteLast() {
        list.add(10);
        list.add(20);
        list.delete(1);
        assertEquals(1, list.count);
    }

    @Test
    public void testDoubleListDeleteOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }
}
