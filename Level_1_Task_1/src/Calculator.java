import java.util.Scanner;

public class Calculator {
    public void performBasicOperations(Scanner scanner) {
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();
        System.out.println("Choose operation: +, -, *, /");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator.");
                return;
        }
        System.out.println("Result: " + result);
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN; // Return NaN to signify an error
        }
        return a / b;
    }
}
