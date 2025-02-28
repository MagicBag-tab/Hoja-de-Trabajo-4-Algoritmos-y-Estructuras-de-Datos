import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class SimpleListTest {

    public SimpleList<Integer> list;

    @Before
    public void setUp() {
        list = new SimpleList<>();
    }

    @Test
    public void testAdd() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.count);
    }

    @Test
    public void testDelete() {
        list.add(10);
        list.add(20);
        list.add(30);

        list.delete(1);

        assertEquals(2, list.count);
    }

    @Test
    public void testSimpleListDeleteFirst() {
        list.add(10);
        list.add(20);
        list.delete(0);
        assertEquals(1, list.count);
    }

    @Test
    public void testSimpleListDeleteOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }
}
