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
        operatorStack.push('#');

        Map<Character, Integer> prioridad = new HashMap<>();
        prioridad.put('+', 1);
        prioridad.put('-', 1);
        prioridad.put('*', 2);
        prioridad.put('/', 2);
        prioridad.put('^', 3);

        for (char character : infix.toCharArray()) {
            if (Character.isDigit(character)) {
                postfix.append(character).append(" ");
            } else if (character == '(') {
                operatorStack.push(character);
            } else if (character == ')') {
                while (!operatorStack.pop().equals('(')) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else {
                while (precedence.containsKey(operatorStack.pop()) &&
                        precedence.get(character) <= precedence.get(operatorStack.pop())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(character);
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