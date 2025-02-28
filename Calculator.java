import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Calculator instance;
    private IStack<Integer> stack;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public void setStack(IStack<Integer> stack) {
        this.stack = stack;
    }

    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> operatorStack = new Stack<>();

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
            } else {
                while (!operatorStack.pop().equals('#') && precedence.containsKey(operatorStack.pop()) &&
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
                stack.push(Integer.parseInt(token));
            } else {
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