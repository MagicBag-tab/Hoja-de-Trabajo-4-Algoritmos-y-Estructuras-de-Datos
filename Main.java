import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = Calculator.getInstanceCalculator();

        System.out.print("Ingrese una expresión en notación infix: ");
        String infixExpression = scanner.nextLine();
        
        String postfixExpression = calculator.infixToPostfix(infixExpression);
        int result = calculator.evaluatePostfix(postfixExpression);
        
        System.out.println("Expresión Postfix: " + postfixExpression);
        System.out.println("Resultado: " + result);
    }
