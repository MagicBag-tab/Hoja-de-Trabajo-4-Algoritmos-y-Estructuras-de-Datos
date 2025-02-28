import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Selección del tipo de stack
        System.out.println("Seleccione el tipo de Stack (Stack, ArrayList, Vector): ");
        String stackType = scanner.nextLine();

        // Selección del tipo de lista (solo si se usa stack basado en lista)
        String listType = null;
        if (stackType.equalsIgnoreCase("Stack")) {
            System.out.println("Seleccione el tipo de Lista (SimpleLinkedList, DoubleLinkedList): ");
            listType = scanner.nextLine();
        }

        // Inicializar Calculator con el tipo de stack
        Calculator calculator = Calculator.getInstance();
        calculator.setStackType(stackType);

        // Leer expresión desde un archivo
        System.out.println("Ingrese el nombre del archivo con la expresión (ejemplo: input.txt): ");
        String fileName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String infixExpression = br.readLine();
            System.out.println("Expresión infija: " + infixExpression);

            // Convertir infijo a postfijo
            String postfixExpression = calculator.infixToPostfix(infixExpression);
            System.out.println("Expresión postfija: " + postfixExpression);

            // Evaluar expresión postfija
            int result = calculator.evaluatePostfix(postfixExpression);
            System.out.println("Resultado: " + result);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}