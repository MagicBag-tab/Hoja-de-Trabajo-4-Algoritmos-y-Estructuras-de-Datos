import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de Stack (ArrayList, Vector, Lista): ");
        String stackType = scanner.nextLine();

        IStack<Integer> stack;
        if (stackType.equalsIgnoreCase("Lista")) {
            System.out.println("Seleccione el tipo de Lista (SimpleLinkedList, DoubleLinkedList): ");
            String listType = scanner.nextLine();
            stack = new Stack<>();
        } else {
            stack = Factory.createArr(stackType);
        }

        Calculator calculator = Calculator.getInstance();
        calculator.setStack(stack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String infixExpression;
            while ((infixExpression = br.readLine()) != null) {
                System.out.println("Expresión infija: " + infixExpression);
                String postfixExpression = calculator.infixToPostfix(infixExpression);
                System.out.println("Expresión postfija: " + postfixExpression);
                int result = calculator.evaluatePostfix(postfixExpression);
                System.out.println("Resultado: " + result);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
