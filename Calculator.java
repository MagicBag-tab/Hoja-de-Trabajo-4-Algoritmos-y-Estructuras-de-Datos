import java.util.HashMap;
import java.util.Map;

/**
 * La clase Calculator proporciona métodos para convertir expresiones infijas a
 * postfijas
 * y evaluar expresiones postfijas.
 */
public class Calculator {
    private static Calculator instance;
    private IStack<Integer> stack;

    private Calculator() {
    }

    /**
     * Devuelve la instancia singleton de la clase Calculator.
     *
     * @return la instancia singleton de la clase Calculator
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Establece la pila a utilizar para evaluar expresiones postfijas.
     *
     * @param stack la pila a utilizar
     */
    public void setStack(IStack<Integer> stack) {
        this.stack = stack;
    }

    /**
     * Convierte una expresión infija a una expresión postfija.
     *
     * @param infix la expresión infija
     * @return la expresión postfija
     */
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> operatorStack = new Stack<>();
        operatorStack.push('#'); // Marca de inicio en la pila

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch).append(" ");
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (true) {
                    char top = operatorStack.pop();
                    if (top == '(')
                        break;
                    postfix.append(top).append(" ");
                }
            } else {
                while (true) {
                    char top = operatorStack.pop();
                    if (top == '#' || (!precedence.containsKey(top) || !precedence.containsKey(ch))
                            || precedence.get(top) < precedence.get(ch)) {
                        operatorStack.push(top);
                        operatorStack.push(ch);
                        break;
                    } else {
                        postfix.append(top).append(" ");
                    }
                }
            }
        }

        while (true) {
            char top = operatorStack.pop();
            if (top == '#')
                break;
            postfix.append(top).append(" ");
        }

        return postfix.toString().trim();
    }

    /**
     * Evalúa una expresión postfija.
     *
     * @param postfix la expresión postfija
     * @return el resultado de la evaluación
     */
    public int evaluatePostfix(String postfix) {
        for (String token : postfix.trim().split("\\s+")) { // ✅ Evita tokens vacíos
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else if (!token.isEmpty()) { // ✅ Verifica que el token no esté vacío
                int b = stack.pop();
                int a = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("División por cero no permitida.");
                        }
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push((int) Math.pow(a, b));
                        break;
                }
            }
        }
        return stack.pop();
    }
}