import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber, String emailAddress) {
        contacts.add(new Contact(name, phoneNumber, emailAddress));
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).toString());
        }
    }

    public void updateContact(int index, String name, String phoneNumber, String emailAddress) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Contact contact = contacts.get(index);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmailAddress(emailAddress);
        System.out.println("Contact updated successfully.");
    }

    public void deleteContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }
        contacts.remove(index);
        System.out.println("Contact deleted successfully.");
    }

}
