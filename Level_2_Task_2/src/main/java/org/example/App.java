package org.example;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        LibraryDatabase.createTables(); // Ensure tables are created
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    String role = loginUser(scanner);
                    if (role != null) {
                        userMenu(scanner, role);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (Librarian/User): ");
        String role = scanner.nextLine().trim().toUpperCase(); // Changed to uppercase for case consistency

        if (role.equals("LIBRARIAN") || role.equals("USER")) {
            UserManagement.registerUser(username, password, role);
        } else {
            System.out.println("Invalid role. Please enter 'Librarian' or 'User'.");
        }
    }

    private static String loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return UserManagement.loginUser(username, password);
    }

    private static void userMenu(Scanner scanner, String role) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Recommend a Book");
            System.out.println("3. Mark Book as Read");
            if (role.equals("LIBRARIAN")) {
                System.out.println("4. Add a Book");
            }
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    BookManagement.viewAvailableBooks();
                    break;
                case 2:
                    BookManagement.recommendBook();
                    break;
                case 3:
                    markBookAsRead(scanner);
                    break;
                case 4:
                    if (role.equals("LIBRARIAN")) {
                        addBook(scanner, role);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return; // Exit the user menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner, String role) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        BookManagement.addBook(title, author, role);
    }

    private static void markBookAsRead(Scanner scanner) {
        System.out.print("Enter book ID to mark as read: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        BookManagement.markBookAsRead(bookId);
    }
}
