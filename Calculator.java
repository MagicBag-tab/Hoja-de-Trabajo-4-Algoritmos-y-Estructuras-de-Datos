import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Calculator instance;
    private IStack<Character> operatorStack;
    private IStack<Integer> valueStack;

    private Calculator() {}

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public void setStackType(String stackType) {
        this.operatorStack = Factory.createArr(stackType);
        this.valueStack = Factory.createArr(stackType);
    }

    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        operatorStack.push('#'); // Caracter especial

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
                while (!operatorStack.pop().equals('(')) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop(); // Eliminar '(' de la pila
            } else { // Es operador
                while (precedence.containsKey(operatorStack.pop()) &&
                        precedence.get(ch) <= precedence.get(operatorStack.pop())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.pop().equals('#')) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public int evaluatePostfix(String postfix) {
        for (String token : postfix.split(" ")) {
            if (token.matches("\\d+")) {
                valueStack.push(Integer.parseInt(token));
            } else {
                int b = valueStack.pop();
                int a = valueStack.pop();
                switch (token.charAt(0)) {
                    case '+': valueStack.push(a + b); break;
                    case '-': valueStack.push(a - b); break;
                    case '*': valueStack.push(a * b); break;
                    case '/': valueStack.push(a / b); break;
                    case '^': valueStack.push((int) Math.pow(a, b)); break;
                }
            }
        }
        return valueStack.pop();
    }
}