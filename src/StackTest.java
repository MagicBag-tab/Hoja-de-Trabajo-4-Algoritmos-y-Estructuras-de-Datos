import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop()); 
        assertEquals(10, stack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("No se encuentra nada en la pila.", exception.getMessage());
    }
}
