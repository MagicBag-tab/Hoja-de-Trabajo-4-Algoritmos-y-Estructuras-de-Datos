import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;
    private IStack<Integer> stack;

    @Before
    public void setUp() {
        calculator = Calculator.getInstance();
        stack = new Stack<>();
        calculator.setStack(stack);
    }

    @Test
    public void testInfixToPostfix() {
        String infix = "3+4*2/(1-5)^2";
        String expectedPostfix = "3 4 2 * 1 5 - 2 ^ / +";
        assertEquals(expectedPostfix, calculator.infixToPostfix(infix));
    }

    @Test
    public void testEvaluatePostfix() {
        String postfix = "3 4 2 * 1 5 - 2 ^ / +";
        int expectedResult = 3;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }

    @Test
    public void testEvaluatePostfixWithDivisionByZero() {
        String postfix = "4 0 /";
        assertThrows(ArithmeticException.class, () -> calculator.evaluatePostfix(postfix));
    }

    @Test
    public void testEvaluatePostfixWithPower() {
        String postfix = "2 3 ^";
        int expectedResult = 8;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }

    @Test
    public void testEvaluatePostfixWithAddition() {
        String postfix = "2 3 +";
        int expectedResult = 5;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }

    @Test
    public void testEvaluatePostfixWithSubtraction() {
        String postfix = "5 3 -";
        int expectedResult = 2;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }

    @Test
    public void testEvaluatePostfixWithMultiplication() {
        String postfix = "2 3 *";
        int expectedResult = 6;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }
}