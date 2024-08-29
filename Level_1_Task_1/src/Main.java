import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ScientificCalculator sciCalculator = new ScientificCalculator();
        UnitConverter unitConverter = new UnitConverter();

        while (true) {
            System.out.println("Welcome to the Enhanced Console Calculator!");
            System.out.println("Choose an option:");
            System.out.println("1. Basic Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    calculator.performBasicOperations(scanner);
                    break;
                case 2:
                    sciCalculator.performScientificOperations(scanner);
                    break;
                case 3:
                    unitConverter.performUnitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the calculator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
