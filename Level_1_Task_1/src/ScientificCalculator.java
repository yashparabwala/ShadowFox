import java.util.Scanner;

public class ScientificCalculator {
    public void performScientificOperations(Scanner scanner) {
        System.out.println("Choose operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.println("3. Sine");
        System.out.println("4. Cosine");
        System.out.println("5. Tangent");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter number:");
                double num = scanner.nextDouble();
                System.out.println("Square Root: " + squareRoot(num));
                break;
            case 2:
                System.out.println("Enter base:");
                double base = scanner.nextDouble();
                System.out.println("Enter exponent:");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + power(base, exponent));
                break;
            case 3:
                System.out.println("Enter angle in degrees:");
                double angle = scanner.nextDouble();
                System.out.println("Sine: " + sine(angle));
                break;
            case 4:
                System.out.println("Enter angle in degrees:");
                angle = scanner.nextDouble();
                System.out.println("Cosine: " + cosine(angle));
                break;
            case 5:
                System.out.println("Enter angle in degrees:");
                angle = scanner.nextDouble();
                System.out.println("Tangent: " + tangent(angle));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private double squareRoot(double num) {
        if (num < 0) {
            System.out.println("Error: Cannot take square root of negative number.");
            return Double.NaN; // Return NaN to signify an error
        }
        return Math.sqrt(num);
    }

    private double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    private double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    private double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    private double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
