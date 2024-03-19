package kthdsa.F1;

import java.util.ArrayList;

public class F1p2 {
    public static boolean delete(ArrayList<String> aList, String target) {
        return aList.remove(target);
    }

    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("banana");
        stringList.add("date");

        // Print the original list
        System.out.println("Original List: " + stringList);

        // Delete occurrences of "banana" from the list
        boolean deletionResult = F1p2.delete(stringList, "banana");

        // Print the modified list
        System.out.println("List after deletion: " + stringList);

        // Print the result of the deletion
        System.out.println("Deletion successful: " + deletionResult);
    }
}
