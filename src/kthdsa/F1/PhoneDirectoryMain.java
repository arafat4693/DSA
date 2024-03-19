package kthdsa.F1;

public class PhoneDirectoryMain {
    public static void main(String[] args) {
        // Create an instance of PhoneDirectory
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Add entries to the directory
        phoneDirectory.addEntry("John Doe", "123-456-7890");
        phoneDirectory.addEntry("Jane Smith", "987-654-3210");
        phoneDirectory.addEntry("Alice Johnson", "555-123-4567");

        // Test indexOf() method
        int index = phoneDirectory.indexOf("Jane Smith");
        System.out.println("Index of 'Jane Smith': " + index);

        // Test get() method
        DirectoryEntry entry = phoneDirectory.get(index);
        System.out.println("Entry at index " + index + ": " + entry.getName() + " - " + entry.getNumber());

        // Test equals() method of DirectoryEntry
        DirectoryEntry entry1 = new DirectoryEntry("John Doe", "123-456-7890");
        DirectoryEntry entry2 = new DirectoryEntry("Alice Johnson", "555-123-4567");
        System.out.println("Are entry1 and entry equal? " + entry1.equals(entry));
        System.out.println("Are entry1 and entry2 equal? " + entry1.equals(entry2));

        // Test toString() method of DirectoryEntry
        System.out.println("String representation of entry: " + entry);
    }
}
