import java.util.Scanner;

public class UnitConverter {
    public void performUnitConversions(Scanner scanner) {
        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kilometers to Miles");
        System.out.println("5. Miles to Kilometers");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter Celsius:");
                double celsius = scanner.nextDouble();
                System.out.println("Fahrenheit: " + celsiusToFahrenheit(celsius));
                break;
            case 2:
                System.out.println("Enter Fahrenheit:");
                double fahrenheit = scanner.nextDouble();
                System.out.println("Celsius: " + fahrenheitToCelsius(fahrenheit));
                break;
            case 3:
                System.out.println("Enter Celsius:");
                celsius = scanner.nextDouble();
                System.out.println("Kelvin: " + celsiusToKelvin(celsius));
                break;
            case 4:
                System.out.println("Enter Kilometers:");
                double kilometers = scanner.nextDouble();
                System.out.println("Miles: " + kilometersToMiles(kilometers));
                break;
            case 5:
                System.out.println("Enter Miles:");
                double miles = scanner.nextDouble();
                System.out.println("Kilometers: " + milesToKilometers(miles));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double kilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    private double milesToKilometers(double miles) {
        return miles / 0.621371;
    }
}
