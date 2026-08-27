import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Bobby Bobbster", "+1 617 555 0101");
        Contact contact2 = new Contact("John Johnson", "+1 617 593 8173");
        Contact contact3 = new Contact("Roy Lee", "+1 617 055 3849");
        Contact contact4 = new Contact("Kimberly Kimchi", "+1 617 198 2039");
        Contact contact5 = new Contact("Joe Joe", "+1 617 290 1974");

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put(contact1.getName(), contact1);
        contacts.put(contact2.getName(), contact2);
        contacts.put(contact3.getName(), contact3);
        contacts.put(contact4.getName(), contact4);
        contacts.put(contact5.getName(), contact5);

        // Step 5: look up a contact
        Contact found = contacts.get("Bobby Bobbster");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        // test with a name that does not exist
        Contact missing = contacts.get("NOT Bobby Bobbster");
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }

        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}