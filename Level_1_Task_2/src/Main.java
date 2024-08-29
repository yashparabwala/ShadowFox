import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Update an existing contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, emailAddress);
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter the contact index to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email address: ");
                    String newEmailAddress = scanner.nextLine();
                    contactManager.updateContact(updateIndex, newName, newPhoneNumber, newEmailAddress);
                    break;
                case 4:
                    System.out.print("Enter the contact index to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    contactManager.deleteContact(deleteIndex);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }

        scanner.close();
    }
}
